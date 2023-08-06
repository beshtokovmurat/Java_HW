package Persons;

public enum BaseHeroTeam1 {
    Mag(1, 20, "Mag", true, "Stand", 8, 20.0), Bandit(1, 20, "Bandit", true, "Stand", 20), Sniper(1, 20, "Sniper", true, "Stand", 70, 20), Plowman(1, 20, "Plowman", true, "Stand", 30, 0);

    private int numberTeam;
    private int health;
    private String name;
    public boolean isLive;
    public String state;
    public int initiative;
    public double mana;
    private int arrows;

    BaseHeroTeam1(int numberTeam, int health, String name, boolean isLive, String state, int initiative) {
        this.numberTeam = numberTeam;
        this.health = health;
        this.name = name;
        this.isLive = isLive;
        // Stand, Busy, Daed, Moving, Attack, Treat
        this.state = state;
        this.initiative = initiative;
    }

    BaseHeroTeam1(int numberTeam, int health, String name, boolean isLive, String state, int initiative, double mana) {
        this.numberTeam = numberTeam;
        this.health = health;
        this.name = name;
        this.isLive = isLive;
        // Stand, Busy, Daed, Moving, Attack, Treat
        this.state = state;
        this.initiative = initiative;
        this.mana = mana;
    }

    BaseHeroTeam1(int numberTeam, int health, String name, boolean isLive, String state, int initiative, int arrows) {
        this.numberTeam = numberTeam;
        this.health = health;
        this.name = name;
        this.isLive = isLive;
        // Stand, Busy, Daed, Moving, Attack, Treat
        this.state = state;
        this.initiative = initiative;
        this.arrows = arrows;
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


