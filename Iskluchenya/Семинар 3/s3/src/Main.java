public class Main {

    public static void main(String[] args) {
        try {
            int a = 5 / 0;

        }  catch (ArithmeticException e) {
          throw new divByZero();
        }
    }
}

class divByZero extends ArithmeticException {
    public divByZero() {
        super("Деление на ноль");
    }
}
