public class Crossbowman extends Person {
    // Арбалетчик - имеют запас стрел
    public int reserveArrows;

    public Crossbowman() {
        super(100, "Crossbowman", 0, 3);
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return String.valueOf(name);
    }

}
