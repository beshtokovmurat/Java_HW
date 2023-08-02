import java.util.ArrayList;

public class Plowman extends Person {
    // Крестьянин - могут передвигаться
    public int speed;
    public int Arrows;

    public Plowman(int numberTeam, int health, String name, int x, int y, boolean isLive, String state, int initiative) {
        super(numberTeam, health, name, x, y, isLive, state, initiative);
    }

    @Override
    public void step(ArrayList<Person> team1, ArrayList<Person> team2) {
        if (!isLive) {
            state = "Died";
            return;
        }
        if (isLive) {
            Arrows++;
            state = "Busy";
        }

        Person ClosestEnemy = FindClosestEnemy(team1);
        if ((int) coordinate_person.distance(ClosestEnemy.coordinate_person) <= 1) {
            doAttack(ClosestEnemy);
            state = "Attack";
        } else {
        }
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
