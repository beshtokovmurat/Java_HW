public class Pikeman extends Person {
    // Копейщик - боевые единицы, скорость передвижения, могут атаковать
    public boolean hurt;
    public int speed;

    public Pikeman() {
        super(100, "Pikeman");
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return String.valueOf(name);
    }
}
