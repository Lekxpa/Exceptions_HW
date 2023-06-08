import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Program1 <V extends View> {
    public static int count = 6;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDate;
    private Integer phoneNumber;
    private String gender;
    private CheckData chDat;
    private V view;
    public Program1(V v) {
        view = v;
    }

    public void start() throws ExceptionData {
//        boolean cond = true;
//        do {
        String data = view.getInput("Введите данные через пробел либо напишите слово Выход. \n" +
                "Формат ввода данных: \n" +
                "Фамилия Имя Отчество ДатаРождения(в формате: dd.mm.yyyy) НомерТелефона(в формате: 89000000000 Пол(в формате: f или m) \n");
//            if (data.equals("Выход")) {
//                cond = false;
//                break;
//            } else {
        String[] arrayData = data.split(" ");
        int counter = arrayData.length;
        if (counter == 0) {
            throw new NullPointerException("Данные не введены");
        } else if
        (counter < count) {
            view.print("Неверно введены данные - не хватает данных. \n" +
                    "Должно быть: \n"
                    + "Фамилия Имя Отчество ДатаРождения(в формате: dd.mm.yyyy) НомерТелефона(в формате: 89000000000 Пол(в формате: f или m\n");
        } else if (counter > count) {
            view.print("Неверно введены данные - много данных. \n"
                    + "Фамилия Имя Отчество ДатаРождения(в формате: dd.mm.yyyy) НомерТелефона(в формате: 89000000000 Пол(в формате: f или m\n");
        } else if (counter == count){
//            try {
//                chDat = new CheckData();
//                chDat.CheckD(arrayData);
                CheckD(arrayData);
//                personDt(chDat);
//                            view.print("Данные записаны в файл! Всего хорошего!");
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (ExceptionData e) {
//                view.print(e.getMessage());
//            }
        }
    }

            public void CheckD(String[] dataString) {
            if (dataString == null) {
                throw new NullPointerException("Данные не введены");
//                }
            StringBuilder messageWrong = new StringBuilder();
            for (String string : arrayData) {
                if (Character.isLetter(string.charAt(0))) {
                    if (string.length() == 1) {
                        if (this.gender == null) {
                            try {
                                this.gender = String.valueOf(checkGender(string));
                            } catch (ExceptionGender e) {
                                messageWrong.append(e.getMessage());
                            }
                        } else {
                            messageWrong.append("Пол указан неверно.\n");
                        }
                    } else {
                        if (this.lastName == null) {
                            try {
                                this.lastName = checkFIO(string);
                            } catch (ExceptionFIO e) {
                                messageWrong.append(e.getMessage());
                            }
                        } else if (this.firstName == null) {
                            try {
                                this.firstName = checkFIO(string);
                            } catch (ExceptionFIO e) {
                                messageWrong.append(e.getMessage());
                            }
                        } else if (this.middleName == null) {
                            try {
                                this.middleName = checkFIO(string);
                            } catch (ExceptionFIO e) {
                                messageWrong.append(e.getMessage());
                            }
                        } else {
                            messageWrong.append("ФИО указано неверно.\n");
                        }
                    }
                } else {
                    if (string.matches("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}")) {
                        if (this.birthDate == null) {
                            try {
                                this.birthDate = checkBirthDate(string);
                            } catch (ExceptionBirth e) {
                                messageWrong.append(e.getMessage());
                            }
                        } else {
                            messageWrong.append("Дата рождения указана неверно. Формат - дд.мм.гггг");
                        }
                    } else {
                        if (this.phoneNumber == null) {
                            try {
                                this.phoneNumber = (int) checkPhoneNumber(string);
                            } catch (ExceptionPhone e) {
                                messageWrong.append(e.getMessage());
                            }
                        } else {
                            messageWrong.append("Номер телефона указан неверно. Формат - 11 цифр - 79000000000");
                        }
                    }
                }
            }
        }
//        public String getLastName () { return lastName; }
    }
            private String checkFIO(String fio) throws ExceptionFIO {
                if (fio.toLowerCase().matches("^[a-zа-яё]*$")) {
                    return fio;
                } else {
                    throw new ExceptionFIO(fio);
                }
            }
            private long checkPhoneNumber(String phonenum) throws ExceptionPhone {
                if (phonenum.length() == 11) {
                    try {
                        return Long.parseLong(phonenum);
                    } catch (NumberFormatException e) {
                        throw new ExceptionPhone(phonenum);
                    }
                } else {
                    throw new ExceptionPhone(phonenum);
                }
            }
            private Gender checkGender(String gen) throws ExceptionGender {
                try {
                    return Gender.valueOf(gen);
                } catch (IllegalArgumentException e) {
                    throw new ExceptionGender(gen);
                }
            }
            private LocalDate checkBirthDate(String bd) throws ExceptionBirth {
                try {
                    return LocalDate.parse(bd, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                } catch (DateTimeParseException e) {
                    throw new ExceptionBirth(bd);
                }
            }
            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("<").append(lastName).append(">")
                        .append("<").append(firstName).append(">")
                        .append("<").append(middleName).append(">")
                        .append("<").append(birthDate).append(">")
                        .append("<").append(phoneNumber).append(">")
                        .append("<").append(gender).append(">");
                return sb.toString();
            }
//                break;
//            break;
//        }
//        while (cond);
    private void personDt(CheckData data) throws IOException {
        File filepath = new File(data.getLastName());
        try (FileWriter fileWriter = new FileWriter(filepath, true)) {
            fileWriter.append(data.toString() + "\n");
        } catch (IOException e) {
            throw e;
        }
    }
}

