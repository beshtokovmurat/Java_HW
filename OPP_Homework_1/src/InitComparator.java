import Persons.*;

import java.util.Comparator;

public class InitComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o2.initiative, o1.initiative);
    }
}
