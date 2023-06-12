import java.util.Random;

public class Main {
//  Посчитать и сохранить в n номер старшего значащего бита выпавшего числа

    public static void main(String[] args) {
// Первый способ
        int i = 20000;
        double k;
        while (i > 10000) {
            k = 10000 * Math.random();
            i = (int) k;
        }
// Второй способ
//        int k;
//        k = 2000;
//        int i = new Random().nextInt(k);
        System.out.println("Случайное число: " + i);
        int n = 0;
        while (i%2 !=1 | i/2 != 0) {
            i = i/2;
            n++;
        }
        System.out.println("Номер старшего значащего бита выпавшего числа " + n);
    }
}
