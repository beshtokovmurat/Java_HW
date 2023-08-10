import javax.management.relation.RoleInfoNotFoundException;
import java.io.IOError;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try (Counter counter = new Counter()) {
            counter.add();
            System.out.println(counter.getValue());
            counter.close();
            System.out.println(counter.getValue());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Counter implements AutoCloseable {
    private Integer value = 0;
    public void add() throws IOException {
        if (value == null) throw new IOException("Значение закрыто");
        value++;
    }
    public Integer getValue() throws IOException {
        if (value == null) throw new IOException("Значение закрыто");
        return this.value;
    }

    @Override
    public void close() throws Exception {
        value = null;
    }
}
