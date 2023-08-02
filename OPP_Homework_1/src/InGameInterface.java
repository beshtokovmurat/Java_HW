import java.util.ArrayList;

public interface InGameInterface {
    void step(ArrayList<Person> team1, ArrayList<Person> team2);
    String getInfo();
}
