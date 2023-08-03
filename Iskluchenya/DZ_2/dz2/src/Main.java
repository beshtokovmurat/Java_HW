
public class Main {

//   Ошибок нет


    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Check(intArray));
    }
    private static boolean Check(Integer[] intArray) {
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
            return true;
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
        return false;
    }
}


