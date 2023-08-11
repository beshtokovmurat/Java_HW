import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.sun.jmx.snmp.ThreadContext.contains;

public class Main {
//
//    Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
//    Фамилия Имя Отчество
//    дата рождения
//    номер телефона
//    пол
//
//    Форматы данных:
//    фамилия, имя, отчество - строки
//    датарождения - строка формата dd.mm.yyyy
//    номертелефона - целое беззнаковое число без форматирования
//    пол - символ латиницей f или m.
//
//    Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки,
//    обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
//
//    Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
//    Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
//    Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
//
//    Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
//    <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
//
//    Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
//    Не забудьте закрыть соединение с файлом.
//    При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.


    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotExist {
        String[] Person, FIO = new String[0];
        String BirthDay = null, Pol = null;
        int NumberPhone = 0;
        File file = new File("Person.txt");
        boolean flag = true;
        while (flag) {
            try {
                Person = prompt(
                        "Введите через пробел следующую информацию:\n " +
                                "1) фамилию, имя, отчество в виде одной строки; \n " +
                                "2) дату рождения в формате dd.mm.yyyy; \n " +
                                "3) номер телефона как целое беззнаковое число \n " +
                                "4) пол в виде символа латиницей f или m \n " +
                                "или наберите exit, чтобы выйти \n");
                checkAmount(Person);
                for (String i:Person) System.out.println(i);
                for (String i : Person) {
                    if (i.equals("exit")) {
                        flag = false;
                        break;
                    }
                    if (i.contains(".")) {
                        BirthDay = i;
                        System.out.println(BirthDay);
                        checkFormat(BirthDay);
                    }
                    if ((i.equals("f")) || (i.equals("m"))) {
                        Pol = i;
                        System.out.println(Pol);
                        checkFormat(Pol);
                    }
                        if (Integer.valueOf(i) == Integer.parseInt(i)) {
                        NumberPhone = Integer.valueOf(i);
                        System.out.println(NumberPhone);
                        checkFormat(NumberPhone);
                    }
                    if (!(i.equals("exit")) && !(i.contains(".")) && !((i.equals("f")) || (i.equals("m"))) && !(Integer.valueOf(i) == Integer.parseInt(i))) {
                        FIO[0] = i;
                        FIO[1] = i + 1;
                        FIO[2] = i + 2;
                        i += 2;
                        System.out.println(i + " " + i + 1 + " " + i + 2);
                        checkFormat(FIO);
                    }
                }
                if (!Person[0].equals("exit")) {
                    System.out.println("Отвечено на " + Person.length + "пункта");
                    System.out.println("ФИО: " + FIO[0] + " " + FIO[1] + " " + FIO[2]);
                    System.out.println("Дата рождения: " + BirthDay);
                    System.out.println("Пол: " + Pol);
                    System.out.println("NumberPhone: " + String.valueOf(NumberPhone));
                }
                ArrayList<String> people = new ArrayList<>(Arrays.asList(Person));
                writeFile(people, file);
            } catch (RuntimeException e) {
                System.out.println();
            }
        }
    }

    // Запрос у пользователя данных:
    public static String[] prompt(String msg) {
        System.out.println(msg);
        return scanner.nextLine().split(" ");
    }

    // Проверка на количество введённых данных:
    public static void checkAmount(String[] Person) {
        if (!Person[0].equals("exit") && Person.length < 6) {
            throw new AmountException(1);
        } else if (!Person[0].equals("exit") && Person.length > 6) {
            throw new AmountException(2);
        }
    }

    // Проверка формата введённых данных:
    public static void checkFormat(String[] FIO) {
        // Проверка фамилии, имени, отчества
        if (checkString(FIO[0]) && checkString(FIO[1]) && checkString(FIO[2]))
            throw new StringException(1);
    }

    public static void checkFormat(String Str) {
        // Проверка даты
        if (!dateValidator(Str)) {
            throw new StringException(3);
        } else
            // Проверка пола
            if (!Str.equals("f") && !Str.equals("m")) throw new StringException(4);
    }

    public static void checkFormat(int NumberPhone) {
        if (!checkString(NumberPhone))
            throw new StringException(2);
    }


    // Проверка на String и Integer
    public static boolean checkString(String line) {
        try {
            Integer.valueOf(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Проверка на String и Integer
    public static boolean checkString(int line) {
        try {
            Integer.valueOf(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Проверка валидности даты:
    public static boolean dateValidator(String date) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy");
        myFormat.setLenient(false);
        try {
            myFormat.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Вывод списка:
    public static void printPB(String[] person) {
        for (String s : person) {
            System.out.print(s + "  ");
        }
        System.out.println();
    }

    // Запись в файл:
    public static void writeFile(ArrayList<String> people, File file) {
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            for (String s : people) {
                fileWriter.write("<" + s + ">");
            }
            fileWriter.append('\n');
            fileWriter.flush();
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
}

// Exceptions:
class AmountException extends RuntimeException {
    public AmountException(int error) {
        super();
        switch (error) {
            case 1:
                System.out.println("Недостаточно информации.");
            case 2:
                System.out.println("Избыток информации.");
        }
    }
}

class StringException extends NumberFormatException {
    public StringException(int error) {
        super();
        switch (error) {
            case 1:
                System.out.println("Проверьте формат ввода: в ФИО должны быть только буквенные значения.");
            case 2:
                System.out.println("Проверьте формат ввода: при вводе номера телефона должны быть только числовые значения.");
            case 3:
                System.out.println("Проверьте формат ввода: дата должна быть в формате: dd.mm.yyyy");
            case 4:
                System.out.println("Проверьте формат ввода: здесь нужно вводить либо f, либо m.");
        }
    }
}

class FileNotExist extends FileNotFoundException {
    public FileNotExist(String path) {
        super("Такого файла не существует: " + path);
    }

    public FileNotExist() {
        super("Такого файла не существует.");
    }
}

