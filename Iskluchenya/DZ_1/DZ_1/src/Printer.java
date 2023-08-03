import java.sql.SQLOutput;

class Answer {
    public static void arrayOutOfBoundsException() {
        // Напишите свое решение ниже
        Integer[] array = new Integer[]{1, 2, 3};
        System.out.println(array[10]);

    }

    public static void divisionByZero() {
        // Напишите свое решение ниже
        int a1 = 10;
        int a2 = 0;
        System.out.println(a1 / a2);
    }

    public static void numberFormatException() {
        // Напишите свое решение ниже
        String S ="s10";
        System.out.println(Integer.parseInt (S));
    }
}

class Main {
    public static void main(String[] args) {
        Answer ans = new Answer();
        try {
            ans.arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }

        try {
            ans.divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }

        try {
            ans.numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        }
    }
}