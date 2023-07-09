public class Main {

//    Проанализировать и описать персонажей: Маг, монах, разбойник, копейщик, снайпер, арбалетчик, крестьянин.
//    На базе описания персонажей описать простейшую иерархию классов.
//    В основной программе создать по одному экземпляру каждого класса

//    Person – человек,
//    Маг, монах – могут вылечить, давать здоровье, энергию,
//    разбойник, копейщик – боевые единицы, скорость передвижения, могут атаковать
//    снайпер, арбалетчик – имеют запас стрел
//    крестьянин - скорость

    public static void main(String[] args) {
        Mag mag = new Mag();
        Monakh monakh = new Monakh();
        Bandit bandit = new Bandit();
        Pikeman pikeman = new Pikeman();
        Sniper sniper = new Sniper();
        Crossbowman crossbowman = new Crossbowman();
        Plowman plowman = new Plowman();


        System.out.println(mag.toString());
        System.out.println(monakh.toString());
        System.out.println(bandit.toString());
        System.out.println(pikeman.toString());
        System.out.println(sniper.toString());
        System.out.println(crossbowman.toString());
        System.out.println(plowman.toString());
    }
}
