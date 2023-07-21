import java.util.ArrayList;

public class Crossbowman extends Person {
    // Арбалетчик - имеют запас стрел
    public int reserveArrows;

    public Crossbowman() {
        super(100, "Crossbowman", 0, 3);
    }


    public Person FindClosestEnemy(Crossbowman crossbowman, ArrayList<Person> team) {
        double min = distance(crossbowman.getX(), crossbowman.getY(), team.get(0).getX(), team.get(0).getY());
        Person teamember1 = crossbowman;
        for (int i = 0; i < team.size(); i++)
            if (distance(crossbowman.getX(), crossbowman.getY(), team.get(i).getX(), team.get(i).getY()) < min) {
                min = distance(crossbowman.getX(), crossbowman.getY(), team.get(i).getX(), team.get(i).getY());
                teamember1 = team.get(i);
            }
        return teamember1;
    }


    public void step(Crossbowman crossbowman, ArrayList<Person> team1, ArrayList<Person> team2) {
        if (super.getHealth() == 0 || reserveArrows == 0){
            return;
        }
        Person ClosestEnemy = FindClosestEnemy(crossbowman, team1);
        doAttack(ClosestEnemy);
        if (team2.contains(Plowman.class)){
            return;
        }
        reserveArrows --;
    }

    @Override
    public void step() {

    }

    @Override
    public String getInfo() {
        return String.valueOf(name);
    }
}
