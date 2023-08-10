import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotExist {
        try {
            File file = new File("C:\\AiOLog.txt");
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
        } catch (FileNotFoundException e) {
            throw new FileNotExist("C:\\AiOLog.txt");
        }

    }
}

class FileNotExist extends FileNotFoundException {
    public FileNotExist(String Path) {
        super("Такого файла не существует - " + Path);
    }

    public FileNotExist() {
        super("Такого файла не существует");
    }
}
