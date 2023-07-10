public class Bandit extends Person {
    // Разбойник - боевые единицы, скорость передвижения, могут атаковать
    public boolean hurt;
    public int speed;

    public Bandit() {
        super(100, "Bandit");
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return String.valueOf(name);
    }

}
