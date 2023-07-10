public class Sniper extends Person {
    // Снайпер - имеют запас стрел
    public int reserveArrows;

    public Sniper() {
        super(100, "Sniper");
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return String.valueOf(name);
    }

}
