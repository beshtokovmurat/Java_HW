import java.util.Random;

public class Main {
// 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i

    public static void main(String[] args) {
        int i = 4000;
        double k;
        while (i > 2000){
            k = 2000 * Math.random();
            i = (int)k;
        }
        System.out.println("Случайное число: " + i);
    }
}
