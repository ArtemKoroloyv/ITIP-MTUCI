public abstract class Animal {
    private String name;
    private int age;
    private String color;

    private static int count = 0; // Статическая переменная-счётчик

    public Animal() {
        this("Без имени", 0, "Неизвестный");
    }

    public Animal(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
        count++;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Статический метод для вывода количества созданных объектов
    public static int getCount() {
        return count;
    }

    // Абстрактные методы (реализуются в потомках)
    public abstract void makeSound();
    public abstract void move();

    // Общий метод
    public String getInfo() {
        return "Имя: " + name + ", Возраст: " + age + ", Цвет: " + color;
    }
}
