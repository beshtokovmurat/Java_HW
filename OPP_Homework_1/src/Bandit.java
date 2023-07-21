public class Bandit extends Person {
    // Разбойник - боевые единицы, скорость передвижения, могут атаковать
    public boolean hurt;
    public int speed;

    public Bandit() {
        super(100, "Bandit", 0, 5);
    }


    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return String.valueOf(name);
    }

}
