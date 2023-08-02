package Persons;

import java.util.ArrayList;

public class Bandit extends Person {
    // Разбойник - боевые единицы, скорость передвижения, могут атаковать
    public boolean hurt;
    public int speed;

    public Bandit(int numberTeam, int health, String name, int x, int y, boolean isLive, String state, int initiative) {
        super(numberTeam, health, name, x, y, isLive, state, initiative);
    }

    @Override
    public void step(ArrayList<Person> team1, ArrayList<Person> team2) {
        if (!isLive) {
            return;
        }
        Person ClosestEnemy = FindClosestEnemy(team1);
        if ((int) coordinate_person.distance(ClosestEnemy.coordinate_person) <= 1) {
            doAttack(ClosestEnemy);
            state = "Attack";
        } else {
            move(ClosestEnemy.coordinate_person, team2);
//            x +=1;
            state = "Moving";
        }
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
