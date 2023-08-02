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

//    Делаем ход пехоты!
//    1. Проверяем здоровье
//    2. Ищем ближайшего врага
//    3. Двигаемся в сторну врага
//    4. Не наступаем на живых персонажей
//    5. Если расстояние до врага одна клетка бём его!


    public static ArrayList<Person> team1 = new ArrayList();
    public static ArrayList<Person> team2 = new ArrayList();
    public static ArrayList<Person> allTeam = new ArrayList();


    public static void main(String[] args) {

        int teamSize = 10;
        for (int i = 1; i < teamSize + 1; i++) {
            switch (new Random().nextInt(4) + 1) {
                case 1:
                    team1.add(new Mag(BaseHeroTeam1.values()[0].getNumberTeam(), BaseHeroTeam1.values()[0].getHealth(), BaseHeroTeam1.values()[0].getName(), 1, i, BaseHeroTeam1.values()[0].getIsLive(), BaseHeroTeam1.values()[0].getState(), BaseHeroTeam1.values()[0].getInitiative(), BaseHeroTeam1.values()[0].getMana()));
                    break;
                case 2:
                    team1.add(new Bandit(BaseHeroTeam1.values()[1].getNumberTeam(), BaseHeroTeam1.values()[1].getHealth(), BaseHeroTeam1.values()[1].getName(), 1, i, BaseHeroTeam1.values()[1].getIsLive(), BaseHeroTeam1.values()[1].getState(), BaseHeroTeam1.values()[1].getInitiative()));
                    break;
                case 3:
                    team1.add(new Sniper(BaseHeroTeam1.values()[2].getNumberTeam(), BaseHeroTeam1.values()[2].getHealth(), BaseHeroTeam1.values()[2].getName(), 1, i, BaseHeroTeam1.values()[2].getIsLive(), BaseHeroTeam1.values()[2].getState(), BaseHeroTeam1.values()[2].getInitiative(), BaseHeroTeam1.values()[2].getReserveArrows()));
                    break;
                case 4:
                    team1.add(new Plowman(BaseHeroTeam1.values()[3].getNumberTeam(), BaseHeroTeam1.values()[3].getHealth(), BaseHeroTeam1.values()[3].getName(), 1, i, BaseHeroTeam1.values()[3].getIsLive(), BaseHeroTeam1.values()[3].getState(), BaseHeroTeam1.values()[3].getInitiative()));
                    break;
            }
        }

        for (int i = 1; i < teamSize + 1; i++) {
            switch (new Random().nextInt(4) + 1) {
                case 1:
                    team2.add(new Monakh(BaseHeroTeam2.values()[0].getNumberTeam(), BaseHeroTeam2.values()[0].getHealth(), BaseHeroTeam2.values()[0].getName(), 10, i, BaseHeroTeam2.values()[0].getIsLive(), BaseHeroTeam2.values()[0].getState(), BaseHeroTeam2.values()[0].getInitiative(), BaseHeroTeam2.values()[0].getMana()));
                    break;
                case 2:
                    team2.add(new Pikeman(BaseHeroTeam2.values()[1].getNumberTeam(), BaseHeroTeam2.values()[1].getHealth(), BaseHeroTeam2.values()[1].getName(), 10, i, BaseHeroTeam2.values()[1].getIsLive(), BaseHeroTeam2.values()[1].getState(), BaseHeroTeam2.values()[1].getInitiative()));
                    break;
                case 3:
                    team2.add(new Crossbowman(BaseHeroTeam2.values()[2].getNumberTeam(), BaseHeroTeam2.values()[2].getHealth(), BaseHeroTeam2.values()[2].getName(), 10, i, BaseHeroTeam2.values()[2].getIsLive(), BaseHeroTeam2.values()[2].getState(), BaseHeroTeam2.values()[2].getInitiative(), BaseHeroTeam2.values()[2].getReserveArrows()));
                    break;
                case 4:
                    team2.add(new Plowman(BaseHeroTeam2.values()[3].getNumberTeam(), BaseHeroTeam2.values()[3].getHealth(), BaseHeroTeam2.values()[3].getName(), 10, i, BaseHeroTeam2.values()[3].getIsLive(), BaseHeroTeam2.values()[3].getState(), BaseHeroTeam2.values()[3].getInitiative()));
                    break;
            }
        }

        System.out.println();

        allTeam.addAll(team1);
        allTeam.addAll(team2);
        allTeam.sort(Person::compareTo);

        View.view();
        Scanner in = new Scanner(System.in);
        while (true) {
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
            View.view();
        }

    }

}