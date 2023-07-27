public enum BaseHeroTeam1 {
    Mag(1, 100, "Mag", 10 , 1, true, "Stand",50), Bandit(1, 100, "Bandit", 10 , 2, true, "Stand",100), Sniper(1, 100, "Sniper", 10 , 3, true, "Stand",70), Plowman(1, 100, "Plowman", 10 , 4, true, "Stand",30);

    private int numberTeam;
    private int health;
    private String name;
    private int x;
    private int y;
    public boolean isLive;
    public String state = "Stand";
    public int initiative;

    BaseHeroTeam1(int numberTeam, int health, String name, int x, int y, boolean isLive, String state, int initiative) {
        this.numberTeam = numberTeam;
        this.health = health;
        this.name = name;
        this.x = x;
        this.y = y;
        this.isLive = isLive;
        // Stand, Busy, Daed, Moving, Attack
        this.state = "Stand";
        this.initiative = initiative;
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

}


