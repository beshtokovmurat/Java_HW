import com.sun.xml.internal.messaging.saaj.util.TeeInputStream;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

//    Проанализировать и описать персонажей: Маг, монах, разбойник, копейщик, снайпер, арбалетчик, крестьянин.
//    На базе описания персонажей описать простейшую иерархию классов.
//    В основной программе создать по одному экземпляру каждого класса

//    Person – человек
//    Маг (Mag), монах (Monakh) – могут вылечить, давать здоровье, энергию
//    разбойник (Bandit), копейщик (Pikeman) – боевые единицы, скорость передвижения, могут атаковать
//    снайпер (Sniper), арбалетчик (Crossbowman) –  имеют запас стрел
//    крестьянин (Plowman) - могут передвигаться

//    Добавить файл с описанием интерфейса.  В котором описать два метода, void step(); и String getInfo();
//    Реализовать интерфейс в абстрактном классе и в наследниках так, чтобы getInfo возвращал тип персонажа.
//    Создать два списка в классе main. В каждый из списков добавить по десять случайных экземнляров наследников BaseHero.
//    Удалить ненужные методы из абстрактного класса, если такие есть. В main пройти по спискам и вызвать у всех персонажей getInfo


//    Создать класс с описанием координат, x и y.
//    Добавить в абстрактный класс поле с координатами и пробросить его инициализацию до конструкторов персонажей. Farmer farmer = new Farmer(getName(), x, y);
//    Найти среди противников ближайшего и вывести расстояние до него и его имя в консоль.

//    Лучники.
//    1.Если жизни 0 вернуть управление
//    2.Если стрел 0 вернуть управление
//    3.Найти ближайшего противника
//    4.Нанести ему среднее повреждение
//    5.Если среди своих есть крестьянин вернут ь управление
//    6.уменьшить кол-во стрел на одну и вернуть управление
//    Вызывать персонажей из обеих комманд в порядке инициативы.


    public static ArrayList<Person> team1 = new ArrayList();
    public static ArrayList<Person> team2 = new ArrayList();
    public static ArrayList<Person> allTeam = new ArrayList();

    public static void main(String[] args) {
//        Mag mag = new Mag();
//        Monakh monakh = new Monakh();
//        Bandit bandit = new Bandit();
//        Pikeman pikeman = new Pikeman();
//        Sniper sniper = new Sniper();
//        Crossbowman crossbowman = new Crossbowman();
//        Plowman plowman = new Plowman();
//
//
//        System.out.println(mag.toString());
//        System.out.println(monakh.toString());
//        System.out.println(bandit.toString());
//        System.out.println(pikeman.toString());
//        System.out.println(sniper.toString());
//        System.out.println(crossbowman.toString());
//        System.out.println(plowman.toString());
//
//        System.out.println();
//        System.out.println(mag.getInfo());
//        System.out.println(monakh.getInfo());
//        System.out.println(bandit.getInfo());
//        System.out.println(pikeman.getInfo());
//        System.out.println(sniper.getInfo());
//        System.out.println(crossbowman.getInfo());
//        System.out.println(plowman.getInfo());

        int teamSize = 10;
        for (int i = 1; i < teamSize + 1; i++) {
            switch (new Random().nextInt(3) + 1) {
                case 1:
                    team1.add(new Crossbowman(BaseHeroTeam1.values()[0].getNumberTeam(), BaseHeroTeam1.values()[0].getHealth(), BaseHeroTeam1.values()[0].getName(), BaseHeroTeam1.values()[0].getX(), BaseHeroTeam1.values()[0].getY(), BaseHeroTeam1.values()[0].getIsLive(), BaseHeroTeam1.values()[0].getState(), BaseHeroTeam1.values()[0].getInitiative()));
                    break;
                case 2:
                    team1.add(new Pikeman(BaseHeroTeam1.values()[1].getNumberTeam(), BaseHeroTeam1.values()[1].getHealth(), BaseHeroTeam1.values()[1].getName(), BaseHeroTeam1.values()[1].getX(), BaseHeroTeam1.values()[1].getY(), BaseHeroTeam1.values()[1].getIsLive(), BaseHeroTeam1.values()[1].getState(), BaseHeroTeam1.values()[1].getInitiative()));
                    break;
                case 3:
                    team1.add(new Monakh(BaseHeroTeam1.values()[2].getNumberTeam(), BaseHeroTeam1.values()[2].getHealth(), BaseHeroTeam1.values()[2].getName(), BaseHeroTeam1.values()[2].getX(), BaseHeroTeam1.values()[2].getY(), BaseHeroTeam1.values()[2].getIsLive(), BaseHeroTeam1.values()[2].getState(), BaseHeroTeam1.values()[2].getInitiative()));
                    break;
                case 4:
                    team1.add(new Plowman(BaseHeroTeam1.values()[3].getNumberTeam(), BaseHeroTeam1.values()[3].getHealth(), BaseHeroTeam1.values()[3].getName(), BaseHeroTeam1.values()[3].getX(), BaseHeroTeam1.values()[3].getY(), BaseHeroTeam1.values()[3].getIsLive(), BaseHeroTeam1.values()[3].getState(), BaseHeroTeam1.values()[3].getInitiative()));
                    break;
            }
        }

        for (int i = 1; i < teamSize + 1; i++) {
            switch (new Random().nextInt(3) + 1) {
                case 1:
                    team2.add(new Sniper(BaseHeroTeam2.values()[0].getNumberTeam(), BaseHeroTeam2.values()[0].getHealth(), BaseHeroTeam2.values()[0].getName(), BaseHeroTeam2.values()[0].getX(), BaseHeroTeam2.values()[0].getY(), BaseHeroTeam2.values()[0].getIsLive(), BaseHeroTeam2.values()[0].getState(), BaseHeroTeam2.values()[0].getInitiative()));
                    break;
                case 2:
                    team2.add(new Bandit(BaseHeroTeam2.values()[1].getNumberTeam(), BaseHeroTeam2.values()[1].getHealth(), BaseHeroTeam2.values()[1].getName(), BaseHeroTeam2.values()[1].getX(), BaseHeroTeam2.values()[1].getY(), BaseHeroTeam2.values()[1].getIsLive(), BaseHeroTeam2.values()[1].getState(), BaseHeroTeam2.values()[1].getInitiative()));
                    break;
                case 3:
                    team2.add(new Mag(BaseHeroTeam2.values()[2].getNumberTeam(), BaseHeroTeam2.values()[2].getHealth(), BaseHeroTeam2.values()[2].getName(), BaseHeroTeam2.values()[2].getX(), BaseHeroTeam2.values()[2].getY(), BaseHeroTeam2.values()[2].getIsLive(), BaseHeroTeam2.values()[2].getState(), BaseHeroTeam2.values()[2].getInitiative()));
                    break;
                case 4:
                    team2.add(new Plowman(BaseHeroTeam2.values()[3].getNumberTeam(), BaseHeroTeam2.values()[3].getHealth(), BaseHeroTeam2.values()[3].getName(), BaseHeroTeam2.values()[3].getX(), BaseHeroTeam2.values()[3].getY(), BaseHeroTeam2.values()[3].getIsLive(), BaseHeroTeam2.values()[3].getState(), BaseHeroTeam2.values()[3].getInitiative()));
                    break;
            }
        }

        System.out.println();
        //       team1.add(BaseHeroTeam1.values()[0].getName());
//        team1.add(BaseHeroTeam1.values()[1].getName());
//        team1.add(BaseHeroTeam1.values()[2].getName());
//        team1.add(BaseHeroTeam1.values()[3].getName());
//
//        team2.add(BaseHeroTeam2.values()[0].getName());
//        team2.add(BaseHeroTeam2.values()[1].getName());
//        team2.add(BaseHeroTeam2.values()[2].getName());
//        team2.add(BaseHeroTeam2.values()[3].getName());


//        for (int i = 0; i<4; i++){
//            team1.add(BaseHeroTeam1.values()[new Random().nextInt(BaseHeroTeam1.values().length)].getName());
//            team2.add(BaseHeroTeam2.values()[new Random().nextInt(BaseHeroTeam2.values().length)].getName());
//        }

//        System.out.println("Первая команда: ");
//        for (int i = 0; i < team1.size(); i++) {
//            System.out.println(i + 1 + ". " + team1.get(i));
//        }
//        System.out.println();
//        System.out.println("Вторая команда: ");
//        for (int i = 0; i < team2.size(); i++) {
//            System.out.println(i + 1 + ". " + team2.get(i));
//        }

//        for (int i = 0; i < team1.size(); i++) {
//            allTeam.add(team1.get(i));
//        }
//        for (int i = 0; i < team2.size(); i++) {
//            allTeam.add(team2.get(i));
//        }

        allTeam.addAll(team1);
        allTeam.addAll(team2);
        allTeam.sort(Person::compareTo);

        Scanner in = new Scanner(System.in);
        while (true) {

            View.view();
            in.nextLine();
            for (Person person : allTeam) {
                if (team2.contains(person)) {
                    person.step(team1, team2);
                } else person.step(team2, team1);
            }
            if (Person.isTeamDie(team1)) {
                System.out.println("Team 2 (Blue) win");
                break;

            }

            if (Person.isTeamDie(team2)) {
                System.out.println("Team 1 (Green) win");
                break;
            }
        }


//        System.out.println();
//        System.out.println("Вce: ");
//        for (int i = 0; i < allTeam.size(); i++) {
//            System.out.println(i + 1 + ". " + allTeam.get(i));
//        }


//        double min = distance(BaseHeroTeam1.values()[0].getX(), BaseHeroTeam1.values()[0].getY(), BaseHeroTeam2.values()[0].getX(), BaseHeroTeam2.values()[0].getY());
//        String teamember1 = BaseHeroTeam1.values()[0].getName();
//        String teamember2 = BaseHeroTeam2.values()[0].getName();
//        for (int i = 0; i < team1.size(); i++) {
//            for (int j = 0; j < team2.size(); j++) {
//                if (distance(BaseHeroTeam1.values()[i].getX(), BaseHeroTeam1.values()[i].getY(), BaseHeroTeam2.values()[j].getX(), BaseHeroTeam2.values()[j].getY()) < min) {
//                    min = distance(BaseHeroTeam1.values()[i].getX(), BaseHeroTeam1.values()[i].getY(), BaseHeroTeam2.values()[j].getX(), BaseHeroTeam2.values()[j].getY());
//                    teamember1 = BaseHeroTeam1.values()[i].getName();
//                    teamember2 = BaseHeroTeam2.values()[j].getName();
//                }
//            }
//        }


//        System.out.println("Ближайшие противники: " + teamember1 + ", " + teamember2 + " и расстояние между ними " + min);
    }


//    public static double distance(int x1, int y1, int x2, int y2) {
//        return Math.sqrt(Math.pow(x2 - x1,2) + Math.pow(y2 - y1,2));
//    }
}
