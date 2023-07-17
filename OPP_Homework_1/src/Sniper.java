public class Sniper extends Person {
    // Снайпер - имеют запас стрел
    public int reserveArrows;

    public Sniper() {
        super(100, "Sniper", 0, 2);
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return String.valueOf(name);
    }

}
