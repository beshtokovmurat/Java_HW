import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Admin\\Downloads\\Исключения\\Семинар 2\\s1\\src\\names");
        List<String[]>lst = readFile(file);
        changeList(lst);
        writeFile(lst,file);
//        System.out.println("Hello World!");
    }

    public static List<String[]> readFile(File file) {
        List<String[]> list = new ArrayList<>();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line.split("="));
            }
        } catch (
                FileNotFoundException e)

        {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void changeList(List<String[]> list) {
        for (String[] i : list) {
            if (!checkException(i[1]) && !i[1].equals("?")) {
                throw new RuntimeException(i[1]);
            }
            if (i[1].equals("?")) {
                i[1] = String.valueOf(i[0].length());
            }
        }
    }

    public static boolean checkException(String line) {
        try {
            Integer.valueOf(line);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void writeFile(List<String[]> list, File file) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (String[] i : list) {
                bufferedWriter.write(i[0]+"="+i[1]);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } ;

    }
}
