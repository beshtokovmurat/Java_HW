public class Main {

    public static void main(String[] args) {
        String[][] ArrStr = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        try {
            int Sum = Main.CheckArray(ArrStr);
            System.out.println(Sum);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());

        }
    }

    public static int CheckArray(String[][] ArrStr) {
        int Sum = 0;
        Integer[][] ArrInt = new Integer[][]{};
        if (ArrStr[0].length != 4 || ArrStr.length != 4) {
            throw new MyAtrraySizeException(ArrStr.length, ArrStr[0].length);
        }
        for (int i = 0; i < ArrStr[0].length; i++) {
            for (int j = 0; j < ArrStr.length; j++) {
                try {
                    Sum = Sum + Integer.parseInt(ArrStr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyAtrrayDataException(i, j);
                }
            }
        }
        return Sum;
    }
}

class MyAtrraySizeException extends RuntimeException {
    public MyAtrraySizeException(int size1, int size2) {
        super("Не подходит размер массива. Ваш массив: " + size1 + "x" + size2);

    }

}

class MyAtrrayDataException extends NumberFormatException {
    public MyAtrrayDataException(int index1, int index2) {
        super("Не удалось преобразовать в int элемент: " + index1 + "x" + index2);

    }

}


