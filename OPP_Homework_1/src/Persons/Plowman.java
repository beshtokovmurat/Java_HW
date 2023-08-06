package Persons;

import java.util.ArrayList;

public class Plowman extends Person {
    // Крестьянин - могут передвигаться
    public int rezervArrows;

    public Plowman(int numberTeam, int health, String name, int x, int y, boolean isLive, String state, int initiative, int rezervArrows) {
        super(numberTeam, health, name, x, y, isLive, state, initiative, rezervArrows);
    }

    @Override
    public String getInfo() {
        return String.format(this.name + ", health = " + this.health + ", [" + coordinate_person.x + ", " + coordinate_person.y + "], state = " + this.state + ", rezervArrows = " + this.rezervArrows);
    }

    @Override
    public void step(ArrayList<Person> Enemy, ArrayList<Person> Friendly) {
        if (!isLive) {
            state = "Died";
            return;
        }
        Person ClosestEnemy = FindClosest(Enemy);
        if (isLive && (int) coordinate_person.distance(ClosestEnemy.coordinate_person) <= 1) {
            doAttack(ClosestEnemy);
            state = "Attack";
        } else {
            rezervArrows++;
            state = "Busy";
        }
        Person ClosestPlowman = FindEnemyPlowman(Enemy);
        if (isLive) {
            doAttack(ClosestPlowman);
            state = "Attack";
        } else {
            rezervArrows++;
            state = "Busy";
        }
    }

}
