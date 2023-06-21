import com.sun.deploy.util.StringUtils;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;

public class Main {

//  Написать программу, которая осуществляет ввод и хранение данных: ФИО, возраст, пол человека:
//            1)	Осуществите ввод данных с консоли
//            2)	с помощью exit выходите из режима ввода данных
//            3)	отображает ФИО, возраст, пол в порядке ввода данных.
//            4)	добавить возможность выхода или вывода списка, отсортированного по возрасту!)
//            5)	*реализовать сортировку по возрасту с использованием индексов
//            6)	*реализовать сортировку по возрасту и полу с использованием индексов

    public static void main(String[] args) {
        ArrayList<Integer> id = new ArrayList<>();
        ArrayList<String> fam = new ArrayList<>();
        ArrayList<String> imya = new ArrayList<>();
        ArrayList<String> ot = new ArrayList<>();
        ArrayList<String> age = new ArrayList<>();
        ArrayList<String> pol = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int i;
        i = 0;
        while (true) {
            System.out.println(String.format("%50s", "").replace(' ', '_'));
            System.out.println("Для выхода наберите q или Q");
            System.out.println("Введите фамилию сотрудника: ");
            id.add(i, i);
            fam.add(i, scanner.nextLine());
            if (fam.get(i).equals("q") || fam.get(i).equals("Q")) {
                break;
            }
            System.out.println("Введите имя сотрудника: ");
            imya.add(i, scanner.nextLine());
            if (imya.get(i).equals("q") || imya.get(i).equals("Q")) {
                break;
            }
            System.out.println("Введите отчетсво сотрудника: ");
            ot.add(i, scanner.nextLine());
            if (ot.get(i).equals("q") || ot.get(i).equals("Q")) {
                break;
            }
            System.out.println("Введите возраст сотрудника: ");
            age.add(i, scanner.nextLine());
            if (age.get(i).equals("q") || age.get(i).equals("Q")) {
                break;
            }
            System.out.println("Введите пол сотрудника (М или Ж): ");
            pol.add(i, scanner.nextLine());
            if (pol.get(i).equals("q") || pol.get(i).equals("Q")) {
                break;
            }
            i += 1;
        }
        if (i == 0) System.out.println("Информации нет");
        else {
            System.out.println("Введенная информация: ");
            for (i = 1; i < fam.size(); i++) {
                System.out.println("Информация о " + i + " человеке: " + id.get(i - 1) + " " + fam.get(i - 1) + " " + imya.get(i - 1) + " " + ot.get(i - 1) + ", " + age.get(i - 1) + ", " + pol.get(i - 1) + ".");
            }
            System.out.println("Хотите выйти из программы или посмотреть список, отсортированный по возрасту с использованием индексов?");
            System.out.println("Введите N, если хотите выйти");
            System.out.println("Введите Y, если хотите посмотреть список, отсортированный по возрасту с использованием индексов?");
            String choice = scanner.nextLine();
            while (choice.equals("N") || choice.equals("n")) {
                System.out.println("Выход из программы");
                break;
            }
            if (choice.equals("Y") || choice.equals("y")) {
                for (i = 0; i < age.size() - 1; i++) {
                    for (int j = i + 1; j < age.size(); j++) {
                        if (Integer.parseInt(age.get(id.get(j))) < Integer.parseInt(age.get(id.get(i)))) {
                            Collections.swap(id, i, j);
                        }
                    }
                }
                System.out.println("Введенная информация, отсортированная по возрасту с использованием индексов: ");
                for (i = 1; i < id.size(); i++) {
                    System.out.println("Информация о " + i + " человеке: " + id.get(i - 1) + " " + fam.get(id.get(i - 1)) + " " + imya.get(id.get(i - 1)) + " " + ot.get(id.get(i - 1)) + ", " + age.get(id.get(i - 1)) + ", " + pol.get(id.get(i - 1)) + ".");
                }
                scanner.close();
            }
        }
    }
}
