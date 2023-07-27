import java.util.ArrayList;

public abstract class Gameinterface {
    abstract void step(ArrayList<Person> enemy, ArrayList<Person> friend);
    abstract String getinfo();
}
