import java.util.ArrayList;

public class Monakh extends Person {
    // Монах - могут вылечить, давать здоровье, энергию
    public int giveHealph;

    public Monakh(int numberTeam, int health, String name, int x, int y, boolean isLive, String state, int initiative) {
        super(numberTeam, health, name, x, y, isLive, state, initiative);
    }

//    public Person FindClosestEnemy(Monakh monakh, ArrayList<Person> team) {
//        double min = distance(monakh.getX(), monakh.getY(), team.get(0).getX(), team.get(0).getY());
//        Person teamember1 = monakh;
//        for (int i = 0; i < team.size(); i++)
//            if (distance(monakh.getX(), monakh.getY(), team.get(i).getX(), team.get(i).getY()) < min || team.get(i) != monakh) {
//                min = distance(monakh.getX(), monakh.getY(), team.get(i).getX(), team.get(i).getY());
//                teamember1 = team.get(i);
//            }
//        return teamember1;
//    }


    @Override
    public void step(ArrayList<Person> team1, ArrayList<Person> team2) {
        Person ClosestEnemy = FindClosestEnemy(team1);
        getLive(ClosestEnemy);
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }


}
