import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program <T extends View> {
    private CheckData chDat;
    private T view;
    public Program(T t) {
        view = t;
    }
    public void start() {
        boolean cond = true;
        do {
            String data = view.getInput("Введите данные через пробел либо напишите слово Выход. \n" +
                    "Формат ввода данных: \n" +
                    "Фамилия Имя Отчество ДатаРождения(в формате: dd.mm.yyyy) НомерТелефона(в формате: 89000000000 Пол(в формате: f или m) \n");
            if (data.equals("Выход")) {
                cond = false;
                break;
            } else {
//                // множественные пробелы заменяем на одинарные (не считаем это страшной ошибкой)
//                String[] splitedInput = input.replaceAll("\\s+", " ").split(" ");
//            Scanner iScanner = new Scanner(System.in);
//            String data = iScanner.nextLine();
                String[] arrayData = data.split(" ");
//                String[] inData = data.replaceAll("\\s+", " ").split(" ");
//                int counter = dataCheck(arrayData.length);
                int counter = arrayData.length;
//                private int dataCheck(int counter) {
                    if (counter == 0) {
                        throw new NullPointerException("Данные не введены");
                    }else if
                    (counter < CheckData.count) {
                        view.print("Неверно введены данные - не хватает данных. \n" +
                                "Должно быть: \n"
                                + "Фамилия Имя Отчество ДатаРождения(в формате: dd.mm.yyyy) НомерТелефона(в формате: 89000000000 Пол(в формате: f или m\n");
                    } else if (counter > CheckData.count) {
                        view.print("Неверно введены данные - много данных. \n"
                                + "Фамилия Имя Отчество ДатаРождения(в формате: dd.mm.yyyy) НомерТелефона(в формате: 89000000000 Пол(в формате: f или m\n");
                    } else {
                        try {
//                            CheckData.CheckD(arrayData);
//                            CheckDataCheckD(arrayData);
                            chDat = new CheckData();
                            chDat.CheckD(arrayData);
                            personDt(chDat);
//                            view.print("Данные записаны в файл! Всего хорошего!");
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ExceptionData e) {
                            view.print(e.getMessage());
                        }
                    }
            }
            break;
        } while (cond);
    }

    // по заданию проверяем кол-во введённых данных через возврат кода ошибки при
    // несоответствии
//    private int dataCheck(int counter) {
//        if (counter < CheckData.count) {
//            return -1;
//        } else if (counter > CheckData.count) {
//            return 0;
//        } else {
//            return counter;
//        }
//    }

    //создаём или подключаемся к фаилу по фамилии и дописываем туда новые данные
    private void personDt(CheckData data) throws IOException {
        File filepath = new File(data.getLastName());
        try (FileWriter fileWriter = new FileWriter(filepath, true)) {
            fileWriter.append(data.toString() + "\n");
        } catch (IOException e) {
            throw e;
        }
    }
}