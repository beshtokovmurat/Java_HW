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
        String[] Person;
        String[] FIO = new String[3];
        String[] NumberPhone = new String[11];
        String BirthDay = null, Pol = null;
        File file = new File("Person.txt");
        boolean flag = true;
        while (flag) {
            try {
                Person = prompt(
                        "Введите через два пробела следующую информацию:\n " +
                                "1) фамилию, имя, отчество в виде одной строки; \n " +
                                "2) дату рождения в формате dd.mm.yyyy; \n " +
                                "3) номер телефона как целое беззнаковое число \n " +
                                "4) пол в виде символа латиницей f или m \n " +
                                "или наберите exit, чтобы выйти \n");
                checkAmount(Person);
//                for (int i=0; i<Person.length; i++) System.out.println(Person[i]);
                for (int i = 0; i < Person.length; i++) {
                    if (Person[i].equals("exit")) {
                        flag = false;
                        break;
                    } else if (Person[i].contains(".")) {
                        BirthDay = Person[i];
                        checkFormat(BirthDay);
                    } else if ((Person[i].equals("f")) || (Person[i].equals("m"))) {
                        Pol = Person[i];
                        checkFormat(Pol);
                    } else if (Person[i].contains(" ")) {
                        FIO = Person[i].split(" ");
                        checkFormat(FIO);
                    } else {
                        for (int j = 0; j < Person[i].length(); j++) {
                            NumberPhone[j] = String.valueOf(Person[i].toCharArray()[j]);
                            checkFormat(Person[i].toCharArray()[j]);
                        }

                    }
                }
                if (!Person[0].equals("exit")) {
                    System.out.println("ФИО: " + FIO[0] + " " + FIO[1] + " " + FIO[2]);
                    System.out.println("Дата рождения: " + BirthDay);
                    System.out.println("Пол: " + Pol);
                    System.out.print("NumberPhone: ");
                    for (int j = 0; j < NumberPhone.length; j++) {
                        System.out.print(String.valueOf(NumberPhone[j]));
                    }
                    System.out.println();
                    System.out.println();
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
        return scanner.nextLine().split("  ");
    }

    // Проверка на количество введённых данных:
    public static void checkAmount(String[] Person) {
        if (!Person[0].equals("exit") && Person.length < 4) {
            throw new AmountException(1);
        } else if (!Person[0].equals("exit") && Person.length > 4) {
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
        if (!dateValidator(Str) && !Str.equals("f") && !Str.equals("m")) {
            throw new StringException(3);
        } else
            // Проверка пола
            if (!Str.contains(".") && !Str.equals("f") && !Str.equals("m")) throw new StringException(4);
    }

    public static void checkFormat(char NumberPhone) {
//        System.out.println(NumberPhone);
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
    public static boolean checkString(char line) {
        try {
            Integer.parseInt(String.valueOf(line));
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
                System.out.println(" Проверьте формат ввода: в ФИО должны быть только буквенные значения.");
            case 2:
                System.out.println(" Проверьте формат ввода: при вводе номера телефона должны быть только числовые значения.");
            case 3:
                System.out.println(" Проверьте формат ввода: дата должна быть в формате: dd.mm.yyyy");
            case 4:
                System.out.println(" Проверьте формат ввода: здесь нужно вводить либо f, либо m.");
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

