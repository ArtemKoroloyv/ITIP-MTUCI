public class Fish extends Animal {
    private String waterType;

    public Fish() {
        super();
        this.waterType = "Пресная";
    }

    public Fish(String name, int age, String color, String waterType) {
        super(name, age, color);
        this.waterType = waterType;
    }

    public String getWaterType() {
        return waterType;
    }

    public void setWaterType(String waterType) {
        this.waterType = waterType;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " не издаёт звуков.");
    }

    @Override
    public void move() {
        System.out.println(getName() + " плавает в воде.");
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Водная среда: " + waterType;
    }
}
