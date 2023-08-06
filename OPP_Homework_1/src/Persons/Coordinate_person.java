package Persons;

import java.util.ArrayList;

public class Coordinate_person {
    int x, y;
    ArrayList<Integer> xy = new ArrayList<>();

    public Coordinate_person(int x, int y) {
        this.x = x;
        this.y = y;
        xy.add(0, x);
        xy.add(1, y);
    }


    public double distance(Coordinate_person coordinate_person) {
        int dx = coordinate_person.x - x;
        int dy = coordinate_person.y - y;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    public Coordinate_person newPosition(Coordinate_person targetPosition, ArrayList<Person> team) {
        Coordinate_person currentPos = new Coordinate_person(x, y);

        if (Math.abs(targetPosition.x - x) >= Math.abs(targetPosition.y - y)) {
            if (targetPosition.x - x > 0) currentPos.x += 1;
            else currentPos.x -= 1;
        }

        if (Math.abs(targetPosition.x - x) < Math.abs(targetPosition.y - y)) {
            if (targetPosition.y - y > 0) currentPos.y += 1;
            else currentPos.y -= 1;
        }
        return currentPos;
    }

    public boolean containsByPos(Coordinate_person nextPosition, ArrayList<Person> team) {
        for (Person person : team) {
            if (person.coordinate_person == nextPosition) return true;
        }
        return false;
    }

}
