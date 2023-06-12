import java.io.*;

public class Main {

    //    Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
//    Если значение null, то параметр не должен попадать в запрос.
//    Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
//    В итоге должно получится select * from students where name=Ivanov, country=Russia, city=Moscow, age=null
//
    public static void main(String[] args) throws Exception {
        try (FileReader reader = new FileReader("C:/file.txt")) {
            // читаем посимвольно
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

