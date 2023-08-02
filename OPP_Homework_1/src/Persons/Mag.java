package Persons;

import java.util.ArrayList;

public class Mag extends Person {
    // Маг - могут вылечить, давать здоровье, энергию
    public int giveHealph;

    public Mag(int numberTeam, int health, String name, int x, int y, boolean isLive, String state, int initiative, double mana) {
        super(numberTeam, health, name, x, y, isLive, state, initiative, mana);
    }

    public double getMana() {
        return mana;
    }

    @Override
    public String getInfo() {
        return String.format(this.name + ", health = " + this.health + ", [" + coordinate_person.x + ", " + coordinate_person.y + "], state = " + this.state + ", mana = " + this.mana);
    }

    @Override
    public void step(ArrayList<Person> team1, ArrayList<Person> team2) {
        if (!isLive) {
            return;
        }

        if (isLive) {
            Person ClosestEnemy = FindClosestEnemy(team2);
            if (ClosestEnemy.health < health && mana > 0) {
                haveLive(ClosestEnemy);
                state = "Treat";
                mana -= 1;
            }
            ClosestEnemy = FindClosestEnemy(team1);
            if (mana >0 && (int) coordinate_person.distance(ClosestEnemy.coordinate_person) <= 1) {
                doAttack(ClosestEnemy);
                mana += 1;
                state = "Attack";
            } else {
                move(ClosestEnemy.coordinate_person, team2);
//                x +=1;
                mana -= 1;
                state = "Busy";
            }
            return;
        }
    }
}
