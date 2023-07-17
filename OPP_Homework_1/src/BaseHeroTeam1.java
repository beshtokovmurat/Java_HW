public enum BaseHeroTeam1 {
    Mag(50, "Mag", 0 , 1), Bandit(50, "Bandit", 0 , 2), Sniper(50, "Sniper", 0 , 3), Plowman(50, "Plowman", 0 , 4);

    private int health;
    private String name;
    private int x;
    private int y;

    BaseHeroTeam1(int health, String name, int x, int y) {
        this.health = health;
        this.name = name;
        this.x = x;
        this.y = y;
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

}
