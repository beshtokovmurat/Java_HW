package Persons;

public enum BaseHeroTeam2 {
    Monakh(2, 10, "Monakh", 10 , 1, true, "Stand",50,10.0), Pikeman(2, 10, "Pikeman", 10 , 2, true, "Stand",100), Crossbowman(2, 10, "Crossbowman", 10 , 3, true, "Stand",70, 5), Plowman(2, 10, "Plowman", 10 , 4, true, "Stand",30);


    private int numberTeam;
    private int health;
    private String name;
    private int x;
    private int y;
    public boolean isLive;
    public String state = "Stand";
    public int initiative;
    public double mana;
    public int reserveArrows;


    BaseHeroTeam2(int numberTeam, int health, String name, int x, int y, boolean isLive, String state, int initiative) {
        this.numberTeam = numberTeam;
        this.health = health;
        this.name = name;
        this.x = x;
        this.y = y;
        this.isLive = isLive;
        // Stand, Busy, Daed, Moving, Attack, Treat
        this.state = "Stand";
        this.initiative = initiative;
    }

    BaseHeroTeam2(int numberTeam, int health, String name, int x, int y, boolean isLive, String state, int initiative, double mana) {
        this.numberTeam = numberTeam;
        this.health = health;
        this.name = name;
        this.x = x;
        this.y = y;
        this.isLive = isLive;
        // Stand, Busy, Daed, Moving, Attack, Treat
        this.state = "Stand";
        this.initiative = initiative;
        this.mana = mana;
    }

    BaseHeroTeam2(int numberTeam, int health, String name, int x, int y, boolean isLive, String state, int initiative, int reserveArrows) {
        this.numberTeam = numberTeam;
        this.health = health;
        this.name = name;
        this.x = x;
        this.y = y;
        this.isLive = isLive;
        // Stand, Busy, Daed, Moving, Attack, Treat
        this.state = "Stand";
        this.initiative = initiative;
        this.reserveArrows = reserveArrows;
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
    public double getMana() { return mana;    }
    public int getReserveArrows() { return reserveArrows;    }
}
