public abstract class Person {
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

}

