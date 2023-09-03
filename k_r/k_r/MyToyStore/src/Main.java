public class Main {

    public static void main(String[] args) {
        // загружаем список имеющихся товаров
        Toys toys = FileManager.loadFromFile();
        // создаем список призов
        Prizes pzs = new Prizes();
        pzs.put(toys.getToy(0));
        pzs.put(toys.getToy(0));
        pzs.put(toys.getToy(1));
        pzs.put(toys.getToy(1));
        pzs.put(toys.getToy(1));
        pzs.put(toys.getToy(1));
        pzs.put(toys.getToy(2));
        pzs.put(toys.getToy(3));
        pzs.put(toys.getToy(3));
        pzs.put(toys.getToy(3));
        // выдача призов
        System.out.println(pzs.get());
        System.out.println(pzs.get());
        System.out.println(pzs.get());
        System.out.println(pzs.get());
        System.out.println(pzs.get());
        System.out.println(pzs.get());
        System.out.println(pzs.get());
        System.out.println(pzs.get());
        System.out.println(pzs.get());
        System.out.println(pzs.get());
        // обновляем базу товаров с учетом выдачи призов
        FileManager.write(toys);
    }
}
