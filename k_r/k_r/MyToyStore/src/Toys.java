import java.util.ArrayList;

public class Toys {
    private ArrayList<Toy> toys;

    public Toys() {
        this.toys = new ArrayList<>();
    }

    public ArrayList<Toy> getToys() {
        return toys;
    }

    public Toy getToy(int index) {
        try {
            return this.toys.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(Сonstants.UNCORR_IDX);
            return null;
        }

    }

    public void addToy(Toy toy) {
        this.toys.add(toy);
    }

    public void print() {
        for (Toy toy : this.toys) {
            System.out.println(toy);

        }
    }

}
