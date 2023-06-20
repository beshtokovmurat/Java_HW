import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;

import static java.lang.Math.random;

// Пусть дан произвольный список целых чисел. Нужно удалить из него чётные числа

public class Main {

    public static void main(String[] args) {
        ArrayList lst1 = new ArrayList();
        lst1 = Inp(5);

        System.out.println("Удаление четных чисел:");
        System.out.println("До --> " + lst1);
        for (int i = 0; i < lst1.size(); i++) {
            if ((Integer) lst1.get(i) % 2 == 0) {
                lst1.remove(lst1.get(i));
            }
        }
        System.out.println("После --> " + lst1);
    }

    public static ArrayList Inp(int n) {
        ArrayList lst = new ArrayList();
        for (int i = 0; i < n; i++) {
            lst.add(new Random().nextInt(100));
        }
        return lst;
    }
}
