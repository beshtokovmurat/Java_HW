package Persons;

import java.util.ArrayList;

public class Mag extends Person {
    // Маг - могут вылечить, давать здоровье, энергию

    public Mag(int numberTeam, int health, String name, int x, int y, boolean isLive, String state, int initiative, double mana) {
        super(numberTeam, health, name, x, y, isLive, state, initiative, mana);
    }

    @Override
    public String getInfo() {
        return String.format(this.name + ", health = " + this.health + ", [" + coordinate_person.x + ", " + coordinate_person.y + "], state = " + this.state + ", mana = " + this.mana);
    }

    @Override
    public void step(ArrayList<Person> Enemy, ArrayList<Person> Friendly) {
        if (!isLive) {
            return;
        }

        Person ClosestFriendly = FindClosest(Friendly);
        if (isLive && ClosestFriendly.health < health && mana > 0) {
            haveLive(ClosestFriendly);
            state = "Healing";
            mana--;
        }
        Person ClosestEnemy = FindClosest(Enemy);
        if (isLive && mana > 0 && (int) coordinate_person.distance(ClosestEnemy.coordinate_person) <= 1) {
            doAttack(ClosestEnemy);
            mana++;
            state = "Attack";
        } else {
            move(ClosestEnemy.coordinate_person, Friendly);
            state = "Busy";
        }
        if (isLive) {
            int countDied = 0;
            for (int i = 0; i < Friendly.size(); i++) {
                if (Friendly.get(i).state == "Died") {
                    countDied++;
                }
                if (mana > 5 && countDied >= Friendly.size() / 2) {
                    ClosestFriendly = FindFriendlyDied(Friendly);
                    ClosestFriendly.health = 10;
                    ClosestFriendly.state = "Stand";
                    ClosestFriendly.isLive = true;
                    mana = 0;
                    state = "Revival";
                }
            }
        }
    }
}
