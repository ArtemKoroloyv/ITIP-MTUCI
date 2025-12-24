public class Loader extends Thread {

    private Warehouse warehouse;

    public Loader(String name, Warehouse warehouse) {
        super(name);
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Product p;

                synchronized (warehouse) {
                    p = warehouse.takeProduct();

                    if (p == null) {
                        if (warehouse.isEmpty()) {
                            warehouse.deliver(getName());
                            break;
                        }
                        warehouse.wait();
                        continue;
                    }

                    System.out.println(getName() + " взял " + p);

                    if (warehouse.isEmpty()) {
                        warehouse.deliver(getName());
                    }
                }

                Thread.sleep(100); // имитация работы
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " прерван");
        }
    }
}
