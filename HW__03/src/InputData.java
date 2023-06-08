import java.util.Scanner;
public class InputData{
    public String[] enterData() {
        Scanner iScanner = new Scanner(System.in);
        boolean cond = true;
        while (true) {
            do {
                System.out.println("Введите данные через пробел либо напишите слово Выход. \n" +
                        "Формат ввода данных: \n" +
                        "Фамилия Имя Отчество ДатаРождения(в формате: dd.mm.yyyy) НомерТелефона(в формате: 89000000000 Пол(в формате: f или m) \n");
                String data = iScanner.nextLine();
                if (data.equals("Выход")) {
                    cond = false;
                    break;
                } else {
                    String[] arrayData = data.split(" ");
                    if (arrayData.length == 6) {
                        return arrayData;
                    } else if (arrayData.length < 6) {
                        System.out.println("Неверно введены данные - не хватает данных. \n" +
                                "Должно быть: \n"
                                + "Фамилия Имя Отчество ДатаРождения(в формате: dd.mm.yyyy) НомерТелефона(в формате: 89000000000 Пол(в формате: f или m\n");
                    } else if (arrayData.length > 6) {
                        System.out.println("Неверно введены данные - много данных. \n"
                                + "Фамилия Имя Отчество ДатаРождения(в формате: dd.mm.yyyy) НомерТелефона(в формате: 89000000000 Пол(в формате: f или m\n");
                    }
                }
            } while (cond) ;
        }
    }
}
