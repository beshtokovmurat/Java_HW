import java.util.ArrayList;

public class Crossbowman extends Person {
    // Арбалетчик - имеют запас стрел
    public int reserveArrows;


    public Crossbowman(int numberTeam, int health, String name, int x, int y, boolean isLive, String state, int initiative) {
        super(numberTeam, health, name, x, y, isLive, state, initiative);
    }


//    public Person FindClosestEnemy(Crossbowman crossbowman, ArrayList<Person> team) {
//        double min = distance(crossbowman.getX(), crossbowman.getY(), team.get(0).getX(), team.get(0).getY());
//        Person teamember1 = crossbowman;
//        for (int i = 0; i < team.size(); i++)
//            if (distance(crossbowman.getX(), crossbowman.getY(), team.get(i).getX(), team.get(i).getY()) < min) {
//                min = distance(crossbowman.getX(), crossbowman.getY(), team.get(i).getX(), team.get(i).getY());
//                teamember1 = team.get(i);
//            }
//        return teamember1;
//    }


    @Override
    public void step(ArrayList<Person> team1, ArrayList<Person> team2) {
        if (super.getHealth() == 0 || reserveArrows == 0){
            return;
        }
        Person ClosestEnemy = FindClosestEnemy(team1);
        doAttack(ClosestEnemy);
        if (team2.contains(Plowman.class)){
            return;
        }
        reserveArrows --;
    }


    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
