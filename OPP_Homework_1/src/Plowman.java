public class Plowman extends Person {
    // Крестьянин - могут передвигаться
    public int speed;

    public Plowman() {
        super(100, "Plowman", 0, 1);
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return String.valueOf(name);
    }

}
