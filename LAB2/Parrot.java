public class Parrot extends Animal {
    private boolean canTalk;

    public Parrot() {
        super();
        this.canTalk = false;
    }

    public Parrot(String name, int age, String color, boolean canTalk) {
        super(name, age, color);
        this.canTalk = canTalk;
    }

    public boolean isCanTalk() {
        return canTalk;
    }

    public void setCanTalk(boolean canTalk) {
        this.canTalk = canTalk;
    }

    @Override
    public void makeSound() {
        if (canTalk) {
            System.out.println(getName() + " говорит: Привет!");
        } else {
            System.out.println(getName() + " чирикает.");
        }
    }

    @Override
    public void move() {
        System.out.println(getName() + " летает по комнате.");
    }

    @Override
    public String getInfo() {
        String talkStr = canTalk ? "умеет говорить" : "не говорит";
        return super.getInfo() + ", Особенность: " + talkStr;
    }
}
