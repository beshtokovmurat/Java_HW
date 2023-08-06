package Persons;

public enum BaseHeroTeam2 {
    Monakh(2, 20, "Monakh", true, "Stand", 50, 20.0), Pikeman(2, 20, "Pikeman", true, "Stand", 100), Crossbowman(2, 20, "Crossbowman", true, "Stand", 70, 20), Plowman(2, 20, "Plowman", true, "Stand", 30, 0);

    private int numberTeam;
    private int health;
    private String name;
    public boolean isLive;
    public String state;
    public int initiative;
    public double mana;
    private int arrows;

    BaseHeroTeam2(int numberTeam, int health, String name, boolean isLive, String state, int initiative) {
        this.numberTeam = numberTeam;
        this.health = health;
        this.name = name;
        this.isLive = isLive;
        // Stand, Busy, Daed, Moving, Attack, Treat
        this.state = state;
        this.initiative = initiative;
    }

    BaseHeroTeam2(int numberTeam, int health, String name, boolean isLive, String state, int initiative, double mana) {
        this.numberTeam = numberTeam;
        this.health = health;
        this.name = name;
        this.isLive = isLive;
        // Stand, Busy, Daed, Moving, Attack, Treat
        this.state = state;
        this.initiative = initiative;
        this.mana = mana;
    }

    BaseHeroTeam2(int numberTeam, int health, String name, boolean isLive, String state, int initiative, int arrows) {
        this.numberTeam = numberTeam;
        this.health = health;
        this.name = name;
        this.isLive = isLive;
        // Stand, Busy, Daed, Moving, Attack, Treat
        this.state = state;
        this.initiative = initiative;
        this.arrows = arrows;
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

    public boolean getIsLive() {
        return isLive;
    }

    public String getState() {
        return state;
    }

    public int getInitiative() {
        return initiative;
    }

    public double getMana() {
        return mana;
    }

    public int getArrows() {
        return arrows;
    }
}
