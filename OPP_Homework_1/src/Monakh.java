public class Monakh extends Person {
    // Монах - могут вылечить, давать здоровье, энергию
    public int giveHealph;

    public Monakh() {
        super(100, "Monakh", 0 , 7);
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return String.valueOf(name);
    }

}
