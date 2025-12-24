import java.util.*;

public class Warehouse {

    private Queue<Product> products = new LinkedList<>();
    private int currentWeight = 0;

    public Warehouse(List<Product> list) {
        products.addAll(list);
    }

    // грузчик берёт товар
    public synchronized Product takeProduct() {
        if (products.isEmpty()) return null;

        Product p = products.peek();
        if (currentWeight + p.getWeight() <= 150) {
            products.poll();
            currentWeight += p.getWeight();
            return p;
        }
        return null;
    }

    // Доставка
    public synchronized void deliver(String loaderName) {
        if (currentWeight == 0) return; // не делаем доставку
        System.out.println(">>> " + loaderName +
                " везёт партию (" + currentWeight + " кг)");
        currentWeight = 0;
        notifyAll();
    }


    public synchronized boolean isEmpty() {
        return products.isEmpty();
    }
}
