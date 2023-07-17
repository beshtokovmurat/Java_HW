public class Coordinate_person {

    int x,y;
    public Coordinate_person(int x, int y){
        this.x = x;
        this.y = y;
    }

    public double distance(Coordinate_person coordinate_person) {
        int dx = coordinate_person.x-x;
        int dy = coordinate_person.y-y;
        return Math.sqrt(Math.pow(dx,2) + Math.pow(dy,2));
    }
}
