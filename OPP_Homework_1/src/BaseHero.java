public enum BaseHero {
    Mag(50, "Mag"), Monakh(50, "Monakh"), Bandit(50, "Bandit"), Pikeman(50, "Pikeman"), Crossbowman(50, "Crossbowman"), Sniper(50, "Sniper"), Plowman(50, "Plowman");

    private int health;
    private String name;

    BaseHero(int health, String name) {
        this.health = health;
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }
}
