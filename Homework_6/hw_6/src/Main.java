import java.util.*;

public class Main {

    public static void main(String[] args) {
        SetAnalog setAnalog = new SetAnalog();
        for (int i = 0; i < 10; i++) {
            setAnalog.add(new Random().nextInt(10));
        }
        Iterator<Integer> iterator = setAnalog.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(setAnalog.delete(9));
        System.out.println(setAnalog.size());
        System.out.println(setAnalog.isEmpty());
        System.out.println(setAnalog.contains(9));
        Iterator<Integer> iterator1 = setAnalog.iterator();
        while (iterator1.hasNext()) {
            int i = iterator1.next();
            System.out.print(i + " ");
        }
    }
}

class SetAnalog<Integer> {
    private HashMap<Integer, Object> map = new HashMap<>();
    private static final Object OBJECT = new Object();

    public boolean add(Integer num) {
        return map.put(num, OBJECT) == null;
    }

    public boolean delete(Integer num) {
        return map.remove(num, OBJECT);
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean contains(Object num) {
        return map.containsKey(num);
    }

    public Iterator<Integer> iterator() {
        return map.keySet().iterator();
    }

    public Integer getElementByIndex(int index) {
        Integer[] mapArray = (Integer[]) map.keySet().toArray();
        return mapArray[index];
    }
}
