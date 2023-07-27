public enum BaseHero {
    Mag(50, "Mag", 0 , 1, true, "Fire",70), Monakh(50, "Monakh", 0 , 1, true, "Fire",70), Bandit(50, "Bandit", 0 , 1, true, "Fire",70), Pikeman(50, "Pikeman", 0 , 1, true, "Fire",70), Sniper(50, "Sniper", 0 , 1, true, "Fire",70), Crossbowman(50, "Crossbowman", 0 , 1, true, "Fire",70), Plowman(50, "Plowman", 0 , 1, true, "Fire",70);

    private int health;
    private String name;
    private int x;
    private int y;
    public boolean isLive;
    public String state = "Stand";
    public int initiative;

    BaseHero(int health, String name, int x, int y, boolean isLive, String state, int initiative) {
        this.health = health;
        this.name = name;
        this.x = x;
        this.y = y;
        this.isLive = isLive;
        // Stand, Busy, Daed, Moving, Attack
        this.state = "Stand";
        this.initiative = initiative;
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
