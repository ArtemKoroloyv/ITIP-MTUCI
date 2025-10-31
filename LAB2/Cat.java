public class Cat extends Animal {
    private String breed;

    public Cat() {
        super();
        this.breed = "Беспородная";
    }

    public Cat(String name, int age, String color, String breed) {
        super(name, age, color);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " говорит: Мяу!");
    }

    @Override
    public void move() {
        System.out.println(getName() + " крадётся тихо на лапках.");
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Порода: " + breed;
    }
}
