import java.util.Locale;
import java.util.Scanner;

public class Main {

//    Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
//    Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
        System.out.println("Введите вещественное число через точку: ");
        while (!CheckFloat(scanner.next())) {
            System.out.println("Введите вещественное число через точку: ");
        }
    }

    public static boolean CheckFloat(String f) {
        try {
            float fl = Float.parseFloat(f);
            System.out.println("Вы ввели вещественное число: " + f);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Вы не ввели вещественное число");
            return false;
        }
    }
}
