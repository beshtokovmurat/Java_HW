public enum BaseHeroTeam1 {
    Mag(1, 10, "Mag", 1 , 1, true, "Stand",8, 10.0), Bandit(1, 10, "Bandit", 1 , 2, true, "Stand",20),  Sniper(1, 10, "Sniper", 1 , 3, true, "Stand",70,5), Plowman(1, 10, "Plowman", 1, 4, true, "Stand",30);

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


    BaseHeroTeam1(int numberTeam, int health, String name, int x, int y, boolean isLive, String state, int initiative) {
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

    BaseHeroTeam1(int numberTeam, int health, String name, int x, int y, boolean isLive, String state, int initiative, double mana) {
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

    BaseHeroTeam1(int numberTeam, int health, String name, int x, int y, boolean isLive, String state, int initiative, int reserveArrows) {
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


