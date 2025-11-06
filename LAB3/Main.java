public class Main {
    public static void main(String[] args) {
        // Создаём хэш-таблицу
        HashTable<String, Product> store = new HashTable<>();

        // Вставка товаров
        store.put("A001", new Product("A001", "Ноутбук", "Игровой, 16 ГБ ОЗУ", 89999.99, 5));
        store.put("A002", new Product("A002", "Мышь", "Беспроводная, оптическая", 1999.99, 20));
        store.put("A003", new Product("A003", "Клавиатура", "Механическая, RGB", 4999.99, 10));

        // Поиск товара по артикулу
        System.out.println("Поиск A002: " + store.get("A002"));

        // Удаление товара
        System.out.println("Удаляем A003: " + store.remove("A003"));

        // Проверка состояния таблицы
        System.out.println("Всего товаров: " + store.size());
        System.out.println("Пуста ли таблица? " + store.isEmpty());
    }
}
