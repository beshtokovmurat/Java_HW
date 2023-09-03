public class Toy implements Comparable<Toy> {
    private Integer id;
    private String name;
    private Integer quantity;
    private Integer proportion;

    public Toy(Integer id, String name, Integer quantity, Integer proportion) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.proportion = proportion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProportion(Integer proportion) {
        this.proportion = proportion;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getProportion() {
        return proportion;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "id: " + this.id + ", Name: " + this.name + ", Quantity: " + this.quantity
                + ", Proportion: " + this.proportion;
    }

    @Override
    public int compareTo(Toy o) {
        return o.proportion.compareTo(proportion);
    }

}
