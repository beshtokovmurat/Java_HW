public class Main {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{0, 0, 0, null};
        System.out.println(SumEl(array));
    }

    public static StringBuilder SumEl(Integer[] array) {
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                stringBuilder.append(i).append(" ");
            }
        }
        if (stringBuilder.length() > 0) {
            throw new RuntimeException("Есть элемент NULL на позициях: " + stringBuilder);
        }
        return stringBuilder;
    }
}