public enum BaseHeroTeam2 {
    Monakh(50, "Monakh", 1 , 1), Pikeman(50, "Pikeman", 1 , 2), Crossbowman(50, "Crossbowman", 1 , 3), Plowman(50, "Plowman", 1 , 4);

    private int health;
    private String name;
    private int x;
    private int y;

    BaseHeroTeam2(int health, String name, int x, int y) {
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
