public class Main {

    public static void main(String[] args) {
        Integer[][] array = new Integer[][]{{0, 0, 1, 1}, {1, 1, 0, 0},{0, 0, 0, 1}, {1, 1, 0, 0}};
        int n = array.length;
        int m = array[0].length;
        System.out.println(SumEl(array, n, m));
    }

    public static Integer SumEl(Integer[][] array, int n, int m) {
        int sum = 0;
        if (n == m) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    sum += array[i][j];
                    if ((array[i][j] != 0) && (array[i][j] != 1)) {
                        throw new RuntimeException("Элементы отличны от 0 и 1");
                    }
                }
            }
        } else throw new RuntimeException("Матрица не квадратная");
        return sum;
    }


}