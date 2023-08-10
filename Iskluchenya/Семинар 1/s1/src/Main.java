public class Main {

    public static void main(String[] args) {
        Integer[] array = {1,2,3,4};
        int m=6;
        System.out.println(ArrayLength(array, m));
    }

    public static int ArrayLength (Integer[] array, int m){
        if (array.length <= m){
            return -1;
        }return array.length;
    }

}
