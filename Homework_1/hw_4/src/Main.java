public class Main {
    //Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
    public static void main(String[] args) {
        int[] m1 = new int[0];
        int n, i, min;
        n = 2;
        min = Short.MIN_VALUE;
        i = 1000;
        for (int j = min; j <= i; j++) {
            if (j % n != 0) {
                int[] temp = new int[m1.length + 1];
                for (int k = 0; k < m1.length; k++) {
                    temp[k] = m1[k];
                }
                m1 = temp;
                m1[m1.length - 1] = j;
            }
        }
        System.out.println("Получен массив");
        for (int j = 0; j < m1.length; j++) {
            System.out.println(m1[j]);
        }
    }
}
