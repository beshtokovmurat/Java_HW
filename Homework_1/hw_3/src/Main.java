public class Main {
    // Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
    public static void main(String[] args) {
        int[] m1 = new int[0];
        int n, i, max;
        n = 7;
        i = 0;
        max = Short.MAX_VALUE;
        for (int j = i; j <= max; j++) {
            if (j % n == 0) {
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
