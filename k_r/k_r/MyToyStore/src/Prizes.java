import java.util.PriorityQueue;

public class Prizes {
    private PriorityQueue<Toy> prizes;

    public Prizes() {
        this.prizes = new PriorityQueue<>();
    }

    public void setPrizes(PriorityQueue<Toy> prizes) {
        this.prizes = prizes;
    }

    public PriorityQueue<Toy> getPrizes() {
        return prizes;
    }

    public void put(Toy toy) {
        try {
            this.prizes.add(toy);
        } catch (NullPointerException e) {
            System.out.println(Сonstants.NULL_ERR);
        }

    }

    public Toy get() {
        try {
            Toy prize = this.prizes.poll();
            if (prize.getQuantity() > 0) {
                prize.setQuantity(prize.getQuantity() - 1);
                FileManager.write(prize);
                return prize;
            } else {
                return null;
            }
        } catch (NullPointerException e) {
            System.out.println(Сonstants.NULL_LIST_ERR);
            return null;
        }
    }

    public void print() {
        if (prizes.isEmpty()) {
            System.out.println(Сonstants.NULL_LIST_MSG);
        } else {
            this.prizes.forEach(item -> System.out.print(item + "\n"));
        }
    }

}
