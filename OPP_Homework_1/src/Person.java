import java.lang.annotation.Target;
import java.util.ArrayList;

public abstract class Person implements StepGet {
    //Человек

    public int health;
    public String name;
    int x,y;

    public Person(int health, String name, int x, int y) {
        this.health = health;
        if (name != null) this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {

        return "name: " + name + ", health = " + String.valueOf(health);
    }

    public void step(Person person, ArrayList<Person> team1, ArrayList<Person> team2) {
    }

    @Override
    public String getInfo() {
        return String.valueOf(name);
    }


    public int getHealth() {
        return health;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void doAttack(Person target){
        int damage = 1;
        target.getDamage(damage);
    }

    public void getDamage(int damage){
        if (this.health-damage>0){
            this.health -= damage;
        }
        else {
            this.health = 0;
        }
    }


    public static String FindClosestEnemy(Person person, ArrayList<Person> team1, ArrayList<Person> team2) {
        double min = distance(person.getX(), person.getY(), team1.get(0).getX(), team1.get(0).getY());
        String teamember1 = "";
        for (int i = 0; i < team1.size(); i++)
            if (distance(person.getX(), person.getY(), team1.get(i).getX(), team1.get(i).getY()) < min) {
                min = distance(person.getX(), person.getY(), team1.get(i).getX(), team1.get(i).getY());
                teamember1 = team1.get(i).name;
            }
        return teamember1;
    }

    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }


}

