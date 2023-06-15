import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
<<<<<<< HEAD

public class Program <V extends View> {
    private CheckData chDat;
    private V view;
    public Program(V v) {
        view = v;
    }
//        private DataChecker model;

    public void start() {
//        boolean cond = true;
//        do {
            String data = view.getInput("Введите данные через пробел либо напишите слово Выход. \n" +
                    "Формат ввода данных: \n" +
                    "Фамилия Имя Отчество ДатаРождения(в формате: dd.mm.yyyy) НомерТелефона(в формате: 89000000000 Пол(в формате: f или m) \n");
//            if (data.equals("Выход")) {
//                cond = false;
//                break;
//
//            } else {
=======
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
>>>>>>> origin/master
//                // множественные пробелы заменяем на одинарные (не считаем это страшной ошибкой)
//                String[] splitedInput = input.replaceAll("\\s+", " ").split(" ");
//            Scanner iScanner = new Scanner(System.in);
//            String data = iScanner.nextLine();
<<<<<<< HEAD
            String[] arrayData = data.split(" ");
//                String[] inData = data.replaceAll("\\s+", " ").split(" ");
//                int counter = personDt(arrayData.length);
            int counter = arrayData.length;
//                private int dataCheck(int counter) {
            if (counter == 0) {
                throw new NullPointerException("Данные не введены");
            } else if
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
//                break;
            }
//            break;
            }

//        }
//        while (cond);




=======
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
>>>>>>> origin/master

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
<<<<<<< HEAD
}
//public class Program< V extends View> {
//
//    private CheckData model;
//    private V view;
//
//    public Program(V v) {
//        view = v;
//    }
//
//    public void start() {
//        boolean wokring = true;
//        do {
//            String input = view.getInput(
//                    "Введите данные через пробел (Фамилию Имя Отчество ДатуРождения НомерТелефона Пол), или Exit для прекращения программы:");
//            if (input.equals("Exit")) {
//                wokring = false;
//                break;
//            } else {
//                // множественные пробелы заменяем на одинарные (не считаем это страшной ошибкой)
//                String[] splitedInput = input.replaceAll("\\s+", " ").split(" ");
//
//                int inputDataCount = checkInputDataCount(splitedInput.length);
//                if (inputDataCount == -1) {
//                    view.print("Слишком мало данных на вводе (должно быть " + CheckData.count
//                            + " разделённых пробелом ' ': Фамилия Имя Отчество НомерТелефона ДатаРождения Пол)\n");
//                } else if (inputDataCount == 0) {
//                    view.print("Слишком много данных на вводе (должно быть " + CheckData.count
//                            + " разделённых пробелом ' ': Фамилия Имя Отчество НомерТелефона ДатаРождения Пол)\n");
//                } else {
//                    try {
//                        model = new CheckData();
//                        model.CheckD(splitedInput);
//                        writePersonData(model);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    } catch (ExceptionData e) {
//                        view.print(e.getMessage());
//                    }
//                }
//            }
//        } while (wokring);
//    }
//
//    // по заданию проверяем кол-во введённых данных через возврат кода ошибки при
//    // несоответствии
//    private int checkInputDataCount(int inputDataCount) {
//        if (inputDataCount < CheckData.count) {
//            return -1;
//        } else if (inputDataCount > CheckData.count) {
//            return 0;
//        } else {
//            return inputDataCount;
//        }
//    }
//
//    //создаём или подключаемся к фаилу по фамилии и дописываем туда новые данные
//    private void writePersonData(CheckData data) throws IOException {
//        File filepath = new File(data.getLastName());
//        try (FileWriter fw = new FileWriter(filepath, true)) {
//            fw.append(data.toString() + "\n");
//        } catch (IOException e) {
//            throw e;
//        }
//    }
//}
//
//
//



//
///
=======
}
>>>>>>> origin/master
