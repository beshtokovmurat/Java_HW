public class Mag extends Person{
    // Маг - могут вылечить, давать здоровье, энергию
    public int giveHealph;

    public Mag() {
        super(100, "Mag", 0, 6);
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return String.valueOf(name);
    }

}
