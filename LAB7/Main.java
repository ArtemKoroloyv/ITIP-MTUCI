import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<Product> products = Arrays.asList(
                new Product("Телевизор", 40),
                new Product("Холодильник", 70),
                new Product("Стол", 10)
        );

        Warehouse warehouse = new Warehouse(products);

        Loader l1 = new Loader("Грузчик-1", warehouse);
        Loader l2 = new Loader("Грузчик-2", warehouse);
        Loader l3 = new Loader("Грузчик-3", warehouse);

        l1.start();
        l2.start();
        l3.start();

        l1.join();
        l2.join();
        l3.join();

        System.out.println("Все товары перенесены.");
    }
}
