import java.util.ArrayList;

public class Pikeman extends Person {
    // Копейщик - боевые единицы, скорость передвижения, могут атаковать
    public boolean hurt;
    public int speed;

    public Pikeman(int numberTeam, int health, String name, int x, int y, boolean isLive, String state, int initiative) {
        super(numberTeam, health, name, x, y, isLive, state, initiative);
    }


    @Override
    public void step(ArrayList<Person> team1, ArrayList<Person> team2) {

    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
