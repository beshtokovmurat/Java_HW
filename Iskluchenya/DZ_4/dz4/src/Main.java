import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

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
        File file = new File("Person.txt");
        while (true) {
            try {
                Person = prompt("Введите через два пробела:\n 1) фамилию, имя, отчество в виде одной строки; \n 2) дату рождения в формате dd.mm.yyyy; \n 3) номер телефона как целое беззнаковое число \n 4) пол в виде символа латиницей f или m \n");
                for(int i = 0; i<Person.length; i++) System.out.println(Person[i]);
                checkAmount(Person);
                for (int i = 0; i < Person.length; i++) {
                    checkFormat(Person, i);
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

    // Проверка формата введённых данных:
    public static void checkFormat(String[] Person, int i) {
        switch (i) {
            case 0: // Проверка фамилии
                if (checkString(Person[0]))
                    throw new StringException(-1);
            case 1: // Проверка имени
                if (checkString(Person[1]))
                    throw new StringException(-1);
            case 2: // Проверка отчества
                if (checkString(Person[2]))
                    throw new StringException(-1);
            case 3: // Проверка даты
                if (!dateValidator(Person[3])) throw new StringException(-3);
            case 4: // Проверка номера телефона
                if (!checkString(Person[4]))
                    throw new StringException(-2);
            case 5: // Проверка пола
                if (!Person[5].equals("f") && !Person[5].equals("m")) throw new StringException(-4);
        }
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

    // Проверка на количество введённых данных:
    public static void checkAmount(String[] Person) {
        if (Person.length < 6) throw new AmountException(-1);
        if (Person.length > 6) throw new AmountException(-3);
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
            case -1:
                System.out.println("Вы ввели меньше данных, чем нужно.");
            case -3:
                System.out.println("Вы ввели больше данных, чем нужно.");
        }
    }
}

class StringException extends NumberFormatException {
    public StringException(int error) {
        super();
        switch (error) {
            case -1:
                System.out.println("Проверьте формат ввода: в ФИО должны быть только буквенные значения.");
            case -2:
                System.out.println("Проверьте формат ввода: при вводе номера телефона должны быть только числовые значения.");
            case -3:
                System.out.println("Проверьте формат ввода: дата должна быть в формате: dd.mm.yyyy");
            case -4:
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

