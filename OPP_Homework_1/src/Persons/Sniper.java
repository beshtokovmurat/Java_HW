package Persons;

import java.util.ArrayList;

public class Sniper extends Person {
// Снайпер - имеют запас стрел


    public Sniper(int numberTeam, int health, String name, int x, int y, boolean isLive, String state, int initiative, int arrows) {
        super(numberTeam, health, name, x, y, isLive, state, initiative, arrows);
    }

    @Override
    public String getInfo() {
        return String.format(this.name + ", health = " + this.health + ", [" + coordinate_person.x + ", " + coordinate_person.y + "], state = " + this.state + ", Arrows = " + this.arrows);
    }

    @Override
    public void step(ArrayList<Person> Enemy, ArrayList<Person> Friendly) {
        if (!isLive) {
            return;
        }

        if (isLive) {
            for (Person person : Friendly) {
                if (person instanceof Person && person.state == "Stand" && arrows < 20 && person instanceof Sniper) {
                    arrows++;
                    person.state = "Busy";
                    return;
                }
            }

            Person ClosestEnemy = FindClosest(Enemy);
            if ((int) coordinate_person.distance(ClosestEnemy.coordinate_person) <= 1) {
                if (arrows > 0) {
                    doAttack(ClosestEnemy);
                    arrows--;
                    state = "Attack";
                    return;
                } else {
                    state = "Busy";
                    Person ClosestPlowman = FindClosest(Friendly);
                    HaveArrows(ClosestPlowman);
                    arrows++;
                }
            } else {
                move(ClosestEnemy.coordinate_person, Friendly);
                state = "Moving";
                return;
            }
            if (Friendly.contains(Plowman.class)) {
                return;
            }
            if (super.getHealth() == 0) {
                return;
            }
        }
        return;
    }
}