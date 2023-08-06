package Persons;

import java.util.ArrayList;

public class Pikeman extends Person {
    // Копейщик - боевые единицы, скорость передвижения, могут атаковать

    public Pikeman(int numberTeam, int health, String name, int x, int y, boolean isLive, String state, int initiative) {
        super(numberTeam, health, name, x, y, isLive, state, initiative);
    }


    @Override
    public void step(ArrayList<Person> Enemy, ArrayList<Person> Friendly) {
        if (!isLive) {
            return;
        }
        if (isLive) {
            Person ClosestEnemy = FindClosest(Enemy);
            if ((int) coordinate_person.distance(ClosestEnemy.coordinate_person) <= 1) {
                doAttack(ClosestEnemy);
                state = "Attack";
            } else {
                move(ClosestEnemy.coordinate_person, Friendly);
                state = "Moving";
            }
        }
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }
}
