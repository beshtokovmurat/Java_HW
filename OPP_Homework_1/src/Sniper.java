import java.util.ArrayList;

public class Sniper extends Person {
    // Снайпер - имеют запас стрел
    public int reserveArrows;

    public Sniper() {
        super(100, "Sniper", 0, 2);
    }

    public void step(Sniper sniper) {
        if (super.getHealth() == 0 || reserveArrows == 0){
            return;
        }
    }

    public Person FindClosestEnemy(Sniper sniper, ArrayList<Person> team) {
        double min = distance(sniper.getX(), sniper.getY(), team.get(0).getX(), team.get(0).getY());
        Person teamember1 = sniper;
        for (int i = 0; i < team.size(); i++)
            if (distance(sniper.getX(), sniper.getY(), team.get(i).getX(), team.get(i).getY()) < min) {
                min = distance(sniper.getX(), sniper.getY(), team.get(i).getX(), team.get(i).getY());
                teamember1 = team.get(i);
            }
        return teamember1;
    }


    public void step(Sniper sniper, ArrayList<Person> team1, ArrayList<Person> team2) {
        if (super.getHealth() == 0 || reserveArrows == 0){
            return;
        }
        Person ClosestEnemy = FindClosestEnemy(sniper, team1);
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
