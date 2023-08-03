import java.util.Scanner;

public class Main {

// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        boolean flag = false;
        while (!flag)
        {
            flag = Check(scanner.nextLine());

        }
    }
    public static boolean Check(String line) {
        if (line.isEmpty()) {
        System.out.println("Вы ввели пустую строку");
            return false;
        }else
        {System.out.println("Вы ввели текст");
        return true;}
    }

}