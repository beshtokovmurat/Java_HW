package Persons;

import java.util.ArrayList;

public abstract class Person implements InGameInterface {
    public static int x;
    public static int y;
    public int initiative, arrows;
    private int numberTeam, MaxHealth;
    protected int health;
    public String name, state;
    public boolean isLive;
    public double attackRange, mana;
    Coordinate_person coordinate_person;
    private Object Plowman;


    public Person(int numberTeam, int health, String name, int x, int y, boolean isLive, String state, int initiative) {
        coordinate_person = new Coordinate_person(x, y);
        this.health = health;
        this.numberTeam = numberTeam;
        this.MaxHealth = health;
        if (name != null) this.name = name;
        this.x = x;
        this.y = y;
        this.isLive = isLive;
        // Stand, Busy, Died, Moving, Attack, Revival, Healing
        this.state = "Stand";
        this.initiative = initiative;
    }

    public Person(int numberTeam, int health, String name, int x, int y, boolean isLive, String state, int initiative, int arrows) {
        coordinate_person = new Coordinate_person(x, y);
        this.health = health;
        this.numberTeam = numberTeam;
        this.MaxHealth = health;
        if (name != null) this.name = name;
        this.x = x;
        this.y = y;
        this.isLive = isLive;
        // Stand, Busy, Died, Moving, Attack, Revival, Healing
        this.state = "Stand";
        this.initiative = initiative;
        this.arrows = arrows;
    }

    public Person(int numberTeam, int health, String name, int x, int y, boolean isLive, String state, int initiative, double mana) {
        coordinate_person = new Coordinate_person(x, y);
        this.health = health;
        this.numberTeam = numberTeam;
        this.MaxHealth = health;
        if (name != null) this.name = name;
        this.x = x;
        this.y = y;
        this.isLive = isLive;
        // Stand, Busy, Died, Moving, Attack, Revival, Healing
        this.state = "Stand";
        this.initiative = initiative;
        this.mana = mana;
    }

    @Override
    public String toString() {
        return "name: " + name + ", health = " + String.valueOf(health);
    }

    public ArrayList<Integer> getCoords() {
        return coordinate_person.xy;
    }

//    public String getInfo() {
//        return String.format(this.name + ", health = " + this.health + ", [" + coordinate_person.x + ", " + coordinate_person.y + "], state = " + this.state);
//    }

    public String getInfo() {
        return String.format(this.name + ", health = " + this.health + ", [" + coordinate_person.x + ", " + coordinate_person.y + "], state = " + this.state);
    }

    protected void healed(int Hp) {
        this.health = Hp + this.health >= this.MaxHealth ? this.MaxHealth : Hp + this.health;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getIsLive() {
        return isLive;
    }

    public String getState() {
        return state;
    }

    public int getInitiative() {
        return initiative;
    }

    public int compareTo(Person o) {
        return o.initiative - this.initiative;
    }


    public int getHp() {
        return health;
    }

    public void doAttack(Person target) {
        int damage = 1;
        target.getDamage(damage);
    }

    public void getDamage(int damage) {
        if (this.health - damage > 0) {
            this.health -= damage;
        } else {
            this.health = 0;
            isLive = false;
            state = "Died";
        }
        if (this.health > health) this.health = health;
    }


    public void haveLive(Person target) {
        int aLive = 1;
        target.getLive(aLive);
    }


    public void getLive(int aLive) {
        if (this.health + aLive < health) {
            this.health += aLive;
        } else {
            this.health = health;
        }
        if (this.health <= 0) {
            isLive = false;
            state = "Died";
        }
    }

    public void HaveArrows(Person getTarget) {
        getTarget.arrows --;
    }

//    public static String FindInitiativeEnemy(ArrayList<Person> team1, ArrayList<Person> team2) {
//        double max = team1.get(0).initiative;
//        for (int i = 0; i < team1.size(); i++)
//            if (team1.get(i).initiative < max) {
//                max = team1.get(i).initiative;
//            }
//        String name = null;
//        for (int i = 0; i < team2.size(); i++)
//            if (team2.get(i).initiative < max) {
//                max = team2.get(i).initiative;
//                name = team2.get(i).name;
//            }
//        return name;
//    }

    public void move(Coordinate_person targetPosition, ArrayList<Person> team) {
        if (!coordinate_person.containsByPos(coordinate_person.newPosition(targetPosition, team), team)) {
            coordinate_person = coordinate_person.newPosition(targetPosition, team);
        }
    }

    public static boolean isTeamDie(ArrayList<Person> team) {
        int count_health;
        count_health = 0;
        for (int i = 0; i < team.size(); i++) {
            if (team.get(i).health == 0) {
                count_health++;
            }
        }
        if (count_health == team.size()) {
            return true;
        } else {
            return false;
        }
    }

    public void step(ArrayList<Person> enemy, ArrayList<Person> friendly) {
    }

    public Person FindClosest(ArrayList<Person> team) {
        double min = Double.MAX_VALUE;
        Person teamember1 = team.get(0);
        for (int i = 0; i < team.size(); i++) {
            if (coordinate_person.distance(team.get(i).coordinate_person) < min && team.get(i).isLive) {
                teamember1 = team.get(i);
                min = coordinate_person.distance(team.get(i).coordinate_person);
            }
        }
        return teamember1;
    }
    public Person FindFriendlyDied(ArrayList<Person> team) {
        Person teamember1 = team.get(0);
        for (int i = 0; i < team.size(); i++) {
            if (team.get(i).state == "Died") {
                teamember1 = team.get(i);
            }
        }
        return teamember1;
    }

    public Person FindEnemyPlowman(ArrayList<Person> team) {
        Person teamember1 = team.get(0);
        for (int i = 0; i < team.size(); i++) {
            if ( team.get(i).isLive && team.contains(Plowman.class) && team.get(i).name.equals(Plowman)) {
                teamember1 = team.get(i);
            }
        }
        return teamember1;
    }

}