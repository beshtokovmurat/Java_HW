package Persons;

import java.util.ArrayList;

public class Crossbowman extends Person {
    private int reserveArrows;
    private int arrows;
    // Арбалетчик - имеют запас стрел

    public Crossbowman(int numberTeam, int health, String name, int x, int y, boolean isLive, String state, int initiative, int reserveArrows) {
        super(numberTeam, health, name, x, y, isLive, state, initiative, reserveArrows);
    }

    public int getReserveArrows() {
        return reserveArrows;
    }

    @Override
    public String getInfo() {
        return String.format(this.name + ", health = " + this.health + ", [" + coordinate_person.x + ", " + coordinate_person.y + "], state = " + this.state + ", Arrows = " + this.reserveArrows);
    }

    @Override
    public void step(ArrayList<Person> team1, ArrayList<Person> team2) {
        if (!isLive) {
            return;
        }

        if (isLive) {
            for (Person person : team2) {
                if (person instanceof Person && person.state == "Stand" && arrows < 20 && this instanceof Crossbowman) {
                    arrows += 1;
                    person.state = "Busy";
                    return;
                }
            }

            Person ClosestEnemy = FindClosestEnemy(team1);
            if ((int) coordinate_person.distance(ClosestEnemy.coordinate_person) <= attackRange) {
                if (arrows > 0 && attackRange != 1) {
                    int damage =1;
                    if (attackRange == 1) ClosestEnemy.getDamage(1);
                    else ClosestEnemy.getDamage(damage);
                    arrows -= 1;
                    state = "Attack";
                    return;
                } else {
                    attackRange = 1;
                    state = "->Melee";
                }
            } else {
                move(ClosestEnemy.coordinate_person, team2);
//                x -= 1;
                state = "Moving";
                return;
            }
            if (team2.contains(Plowman.class)) {
                return;
            }
            if (super.getHealth() == 0) {
                return;
            }
        }
        return;
    }
}