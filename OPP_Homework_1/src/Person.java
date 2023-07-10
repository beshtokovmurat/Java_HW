public abstract class Person implements StepGet{
    //Человек

    public int health;
    public String name;

    public Person(int health, String name) {
        this.health = health;
        if (name != null) this.name = name;
    }

    @Override
    public String toString() {

        return "name: " + name + ", health = " + String.valueOf(health);
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return String.valueOf(name);
    }


}

