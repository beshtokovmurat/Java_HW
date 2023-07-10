import java.util.ArrayList;
import java.util.Random;

public class Main {

//    Проанализировать и описать персонажей: Маг, монах, разбойник, копейщик, снайпер, арбалетчик, крестьянин.
//    На базе описания персонажей описать простейшую иерархию классов.
//    В основной программе создать по одному экземпляру каждого класса

//    Person – человек
//    Маг, монах – могут вылечить, давать здоровье, энергию
//    разбойник, копейщик – боевые единицы, скорость передвижения, могут атаковать
//    снайпер, арбалетчик –  имеют запас стрел
//    крестьянин - могут передвигаться

//    Добавить файл с описанием интерфейса.  В котором описать два метода, void step(); и String getInfo();
//    Реализовать интерфейс в абстрактном классе и в наследниках так, чтобы getInfo возвращал тип персонажа.
//    Создать два списка в классе main. В каждый из списков добавить по десять случайных экземнляров наследников BaseHero.
//    Удалить ненужные методы из абстрактного класса, если такие есть. В main пройти по спискам и вызвать у всех персонажей getInfo.


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
        for (int i = 0; i<10; i++){
            team1.add(BaseHero.values()[new Random().nextInt(BaseHero.values().length)].getName());
            team2.add(BaseHero.values()[new Random().nextInt(BaseHero.values().length)].getName());
        }

        System.out.println("Первая команда: ");
        for (int i = 0; i<team1.size(); i++) {
            System.out.println(i+1 + ". "+ team1.get(i));
        }
        System.out.println();
        System.out.println("Вторая команда: ");
        for (int i = 0; i<team2.size(); i++) {
            System.out.println(i+1 + ". "+ team2.get(i));
        }
    }
}
