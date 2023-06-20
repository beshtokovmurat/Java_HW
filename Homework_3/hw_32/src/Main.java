import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Random;

import static java.lang.Math.random;

// Пусть дан произвольный список целых чисел. Найти минимальное, максимальное и среднее всех значении

public class Main {

    public static void main(String[] args) {
        ArrayList lst1 = new ArrayList();
        lst1 = Inp(5);

        System.out.println("Минимальное значение:");
        System.out.println("Массив --> " + lst1);
        System.out.println("max = " + Collections.max(lst1));
        System.out.println("min = " + Collections.min(lst1));
        System.out.println("Среднее = " + middle(lst1));
    }

    public static ArrayList Inp(int n) {
        ArrayList lst = new ArrayList();
        for (int i = 0; i < n; i++) {
            lst.add(new Random().nextInt(100));
        }
        return lst;
    }

    public static double middle(ArrayList<Integer> lst) {
        long sum =0;
        for (int i: lst) {
            sum += i;
        }        return lst.size()>0 ? (double) sum/lst.size():0;
    }
}
