public class Main {

    public static void main(String[] args) {
        Integer[] array = {1,2,3,4};
//        Integer[] array = null;
        int m = 3;
        System.out.println(printArray(checkArray(array, m)));
    }

    public static int checkArray(Integer[] array, int m) {
        if (array == null) return -3;
        if (array.length <= m) {
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == m) return i;
        }
        return -2;
    }

    public static String printArray(int error) {
        if (error == -1) return "Длина меньше m";
        if (error == -2) return "Искомый элемент не найден";
        if (error == -3) return "Массив нулевой";
        return "Индекс искомого элемента = "+ error;
    }

}