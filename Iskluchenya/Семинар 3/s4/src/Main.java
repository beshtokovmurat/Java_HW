public class Main {

    public static void main(String[] args) {
        try {
            Integer[] array = new Integer[]{1,null};
            array[1] += 1;

        }
        catch (NullPointerException e) {
            throw new  NullEllemenet();
        }
    }
}

class NullEllemenet extends NullPointerException {
    public NullEllemenet(int index) {
        super("Нулевой элемент = " + index);
    }
    public NullEllemenet() {
        super("Нулевой элемент! ");
    }
}
