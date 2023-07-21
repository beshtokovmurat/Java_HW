import java.util.ArrayList;
import java.util.Random;

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


    public static void main(String[] args) {
        ArrayList team1 = new ArrayList();
        ArrayList team2 = new ArrayList();

        Mag mag = new Mag();
        Monakh monakh = new Monakh();
        Bandit bandit = new Bandit();
        Pikeman pikeman = new Pikeman();
        Sniper sniper = new Sniper();
        Crossbowman crossbowman = new Crossbowman();
        Plowman plowman = new Plowman();
//
//
        System.out.println(mag.toString());
        System.out.println(monakh.toString());
        System.out.println(bandit.toString());
        System.out.println(pikeman.toString());
        System.out.println(sniper.toString());
        System.out.println(crossbowman.toString());
        System.out.println(plowman.toString());

        System.out.println();
        System.out.println(mag.getInfo());
        System.out.println(monakh.getInfo());
        System.out.println(bandit.getInfo());
        System.out.println(pikeman.getInfo());
        System.out.println(sniper.getInfo());
        System.out.println(crossbowman.getInfo());
        System.out.println(plowman.getInfo());

        System.out.println();
        team1.add(BaseHeroTeam1.values()[0].getName());
        team1.add(BaseHeroTeam1.values()[1].getName());
        team1.add(BaseHeroTeam1.values()[2].getName());
        team1.add(BaseHeroTeam1.values()[3].getName());

        team2.add(BaseHeroTeam2.values()[0].getName());
        team2.add(BaseHeroTeam2.values()[1].getName());
        team2.add(BaseHeroTeam2.values()[2].getName());
        team2.add(BaseHeroTeam2.values()[3].getName());


//        for (int i = 0; i<4; i++){
//            team1.add(BaseHeroTeam1.values()[new Random().nextInt(BaseHeroTeam1.values().length)].getName());
//            team2.add(BaseHeroTeam2.values()[new Random().nextInt(BaseHeroTeam2.values().length)].getName());
//        }

        System.out.println("Первая команда: ");
        for (int i = 0; i < team1.size(); i++) {
            System.out.println(i + 1 + ". " + team1.get(i));
        }
        System.out.println();
        System.out.println("Вторая команда: ");
        for (int i = 0; i < team2.size(); i++) {
            System.out.println(i + 1 + ". " + team2.get(i));
        }
        double min = distance(BaseHeroTeam1.values()[0].getX(), BaseHeroTeam1.values()[0].getY(), BaseHeroTeam2.values()[0].getX(), BaseHeroTeam2.values()[0].getY());
        String teamember1 = BaseHeroTeam1.values()[0].getName();
        String teamember2 = BaseHeroTeam2.values()[0].getName();
        for (int i = 0; i < team1.size(); i++) {
            for (int j = 0; j < team2.size(); j++) {
                if (distance(BaseHeroTeam1.values()[i].getX(), BaseHeroTeam1.values()[i].getY(), BaseHeroTeam2.values()[j].getX(), BaseHeroTeam2.values()[j].getY()) < min) {
                    min = distance(BaseHeroTeam1.values()[i].getX(), BaseHeroTeam1.values()[i].getY(), BaseHeroTeam2.values()[j].getX(), BaseHeroTeam2.values()[j].getY());
                    teamember1 = BaseHeroTeam1.values()[i].getName();
                    teamember2 = BaseHeroTeam2.values()[j].getName();
                }
            }
        }



        System.out.println("Ближайшие противники: " + teamember1 + ", " + teamember2+ " и расстояние между ними " + min);
    }

    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1,2) + Math.pow(y2 - y1,2));
    }
}
