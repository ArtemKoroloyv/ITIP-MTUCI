public class Main {
    public static void main(String[] args) {
        System.out.println("=== Создание объектов животных ===");

        Cat cat = new Cat("Мурка", 3, "Белый", "Сиамская");
        Parrot parrot = new Parrot("Кеша", 2, "Жёлтый", true);
        Fish fish = new Fish("Гуппи", 1, "Синий", "Пресная");

        Animal[] animals = {cat, parrot, fish};

        for (Animal a : animals) {
            System.out.println("\n" + a.getInfo());
            a.makeSound();
            a.move();
        }

        System.out.println("\nВсего создано животных: " + Animal.getCount());
    }
}
