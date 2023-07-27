import java.util.ArrayList;

public abstract class Person implements StepGet {
    //Человек

    private int numberTeam;
    public int health;
    public int MaxHealth;
    public String name;
    int x, y;
    public boolean isLive;
    public String state = "Stand";
    public int initiative;
    protected Coordinate_person coordinate_person;


    public Person(int numberTeam, int health, String name, int x, int y, boolean isLive, String state, int initiative) {
        this.coordinate_person = new Coordinate_person(x, y);
        this.numberTeam = numberTeam;
        this.health = health;
        this.MaxHealth = health;
        if (name != null) this.name = name;
        this.x = x;
        this.y = y;
        this.isLive = isLive;
        // Stand, Busy, Daed, Moving, Attack, Treat
        this.state = "Stand";
        this.initiative = initiative;
    }

     @Override
    public String toString() {
        return "name: " + name + ", health = " + String.valueOf(health);
    }

    public String getInfo() {
        return String.format(this.name + ", health = "+ this.health + ", initiative = "+ this.initiative);
    }

    protected void healed(int Hp) {
        this.health = Hp + this.health >= this.MaxHealth ? this.MaxHealth : Hp + this.health;
    }

    public int getNumberTeam() {
        return numberTeam;
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


//    public String toString(){
//        return this.getClass().getSimpleName();
//    }

    public int compareTo(Person o) {
        return o.initiative - this.initiative;
    }

    public void compareTo(Object o, Object o1) {
    }


//    public getCoords(){
//        int [] coord = new int []{coordinates.x,coordinates.y};
//        return coord;
//        }

    public int getHp() {
        return health;
    }

    public void doAttack(Person target) {
        int damage = 1;
        target.getDamage(damage);
    }


    public void getLive(Person target) {
        int aLive = 1;
        target.getDamage(-aLive);
    }


    public void goHaveMaxInitiative(ArrayList<Person> team1, ArrayList<Person> team2) {
        step(team1, team2);
    }


    public void getDamage(int damage) {
        if (this.health - damage > 0) {
            this.health -= damage;
        } else {
            this.health = 0;
            isLive = false;
            state = "Dead";
        }
        if (this.health > health) this.health = health;
    }

    public static String FindInitiativeEnemy(ArrayList<Person> team1, ArrayList<Person> team2) {
        double max = team1.get(0).initiative;
        for (int i = 0; i < team1.size(); i++)
            if (team1.get(i).initiative < max) {
                max = team1.get(i).initiative;
            }
        String name = null;
        for (int i = 0; i < team2.size(); i++)
            if (team2.get(i).initiative < max) {
                max = team2.get(i).initiative;
                name = team2.get(i).name;
            }
        return name;
    }

    public static boolean isTeamDie(ArrayList<Person> team1) {
        int count_health;
        count_health = 0;
        for (int i = 0; i < team1.size(); i++) {
            if (team1.get(i).health == 0) {
                count_health++;
            }
        }
        if (count_health == team1.size()) {return true;}
        else {return false;}
    }

    public void step(ArrayList<Person> team1, ArrayList<Person> team2) {
        }


        public Person FindClosestEnemy(ArrayList<Person> team1) {
        double min = coordinate_person.distance(team1.get(0).coordinate_person);
        Person teamember1 = null;
        for (int i = 1; i < team1.size(); i++)
            if (coordinate_person.distance(team1.get(i).coordinate_person)> min){
                min = coordinate_person.distance(team1.get(i).coordinate_person);
                teamember1 = team1.get(i);
            }
//            if (distance(person.getX(), person.getY(), team1.get(i).getX(), team1.get(i).getY()) < min) {
//                min = distance(person.getX(), person.getY(), team1.get(i).getX(), team1.get(i).getY());
//                teamember1 = team1.get(i).name;
//            }
        return teamember1;
    }

    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }


}

