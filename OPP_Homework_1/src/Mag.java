import java.util.ArrayList;

public class Mag extends Person {
    // Маг - могут вылечить, давать здоровье, энергию
    public int giveHealph;
    private ArrayList<Person> team1;


    public Mag(int numberTeam, int health, String name, int x, int y, boolean isLive, String state, int initiative) {
        super(numberTeam, health, name, x, y, isLive, state, initiative);
    }


//    public Person FindClosestEnemy(Mag mag, ArrayList<Person> team) {
//        double min = distance(mag.getX(), mag.getY(), team.get(0).getX(), team.get(0).getY());
//        Person teamember1 = mag;
//        for (int i = 0; i < team.size(); i++)
//            if (distance(mag.getX(), mag.getY(), team.get(i).getX(), team.get(i).getY()) < min || team.get(i) != mag) {
//                min = distance(mag.getX(), mag.getY(), team.get(i).getX(), team.get(i).getY());
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
