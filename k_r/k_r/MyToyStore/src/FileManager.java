import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static void write(Toy toy) {
        try (FileWriter writer = new FileWriter(Сonstants.PRIZES_FILE_NAME, true)) {
            writer.write(toyToStr(toy));
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(Toys toys) {
        try (FileWriter writer = new FileWriter(Сonstants.TOYS_FILE_NAME, false)) {
            for (Toy toy : toys.getToys()) {
                writer.write(toyToStr(toy));
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Toys loadFromFile() {
        Toys toys = new Toys();
        try (FileReader fr = new FileReader(Сonstants.TOYS_FILE_NAME)) {
            try (BufferedReader reader = new BufferedReader(fr)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    toys.addToy(getToy(str_to_arr(line)));
                    ;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return toys;
    }

    private static String[] str_to_arr(String str) {
        return str.split(" ");
    }

    private static Toy getToy(String[] arr) {
        return new Toy(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]));
    }

    private static String toyToStr(Toy toy) {
        String line = toy.getId() + " " + toy.getName() + " " + toy.getQuantity() + " " + toy.getProportion() + "\n";
        return line;
    }
}
