//import java.io.Writer messageWrong;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
        import java.util.Scanner;

public class Program <V extends View> {
    public static int count = 6;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDate;
    private Integer phoneNumber;
    private Gender gender;
    private CheckData chDat;
    private V view;

    public Program(V v) {
        view = v;
    }

    public String start() throws IOException, ExceptionFIO, ExceptionBirth, ExceptionPhone, ExceptionGender {
//        boolean cond = true;
//        do {
        Scanner iScanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите данные через пробел либо напишите слово Выход. \n" +
                    "Формат ввода данных: \n" +
                    "Фамилия Имя Отчество ДатаРождения(в формате: dd.mm.yyyy) НомерТелефона(в формате: 89000000000 Пол(в формате: f или m) \n");
            String data = iScanner.nextLine();
            String[] arrayData = data.split(" ");
            int counter = arrayData.length;
            if (counter == count) {
                for (String i : arrayData) {

                    Writer messageWrong;
                    if (arrayData[0].matches("^[a-zа-яё]*$") && arrayData[1].matches("^[a-zа-яё]*$") && arrayData[2].matches("^[a-zа-яё]*$")) {
                        if (arrayData[0].matches("^[a-zа-яё]*$")) {
//                            try {
//                            return arrayData[0];
                            personDt(arrayData[0]);
//                                this.lastName = checkFIO(i);
                        } else {
                            throw new ExceptionFIO(arrayData[0]);
//                            } catch (ExceptionFIO e) {
//                                messageWrong.append(e.getMessage());
//                            }
                        }
                    } else if (arrayData[1].matches("^[a-zа-яё]*$")) {
//                            try {
//                                this.firstName = checkFIO(i);
                        personDt(arrayData[1]);
                    } else {
                        throw new ExceptionFIO(arrayData[1]);
//                            } catch (ExceptionFIO e) {
//                                messageWrong.append(e.getMessage());
//                            }
                    }
                }
//                            } catch (ExceptionFIO e) {
//                                messageWrong.append(e.getMessage());
//                            }
            } else if (arrayData[2].matches("^[a-zа-яё]*$")) {
                try {
//                                this.middleName = checkFIO(i);
                    personDt(arrayData[2]);
//                            } catch (ExceptionFIO e) {
//                                messageWrong.append(e.getMessage());
//                            }
//                        } else {
//                            messageWrong.append("ФИО указано неверно.\n");
//                        }
//                        checkFIO(i);
                }
            } else if (arrayData[3].matches("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}")) {
                try {
//                            this.birthDate = checkBirthDate(i);
                    personDt(arrayData[3]);
                    return LocalDate.parse(bd, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                } catch (DateTimeParseException e) {
                    throw new ExceptionBirth(bd);
                }
//                        } catch (ExceptionBirth e) {
//                            messageWrong.append(e.getMessage());
//                        }
//                    } else {
//                        messageWrong.append("Дата рождения указана неверно. Формат - дд.мм.гггг");
            }

//                        checkBirthDate(i);
            else if (arrayData[4].matches("[0-9]{11}")) {
//                        checkPhoneNumber(i);
//                         else if (i.matches("[0-9]+")) {
                personDt(arrayData[4]);

//            else {
                try {
                    throw new ExceptionPhone(i);
                } catch (ExceptionPhone e) {
                    e.ExceptionPhone(i);
                }
            }

                    } else if (i.length() == 1) {
                        if (i.equals("f") || i.equals("m")) {
                            personDt(arrayData[5]);
                        } else {
                            try {
                                throw new ExceptionGender(i);
                            } catch (ExceptionGender e) {
                                messageWrong.append(e.getMessage());
                            }

                        }
                    }else{
                            messageWrong.append("Пол указан неверно.\n");
                        }
                    }

//                (i.length() == 1) {
//                        if (this.gender == Gender.f || this.gender == Gender.m) {
//                            try {
//                                this.gender = checkGender(i);
//                            } catch (ExceptionGender e) {
//                                messageWrong.append(e.getMessage());
//                            }
//                        } else {
//                            messageWrong.append("Пол указан неверно.\n");
//                        }
////                            checkGender(i);
//                        }
//                    }
//                    chDat = new CheckData();
//                    chDat.arrayData;
//                    personDt(arrayData);
//                }


//                    return arrayData;
//                CheckD(arrayData);
            }
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
            }
        }
    }
        public void CheckD(String[] arrayData) {
//            ParsData parsData = new ParsData(); // Создается объект класса ParsData
//            String newFileName = null; // Иннициализация переменной
//            WriteFile writeFile = new WriteFile(); // Создается объект класса WriteFile
//
//            HashMap<String, Object> data = parsData.parsInputData(); // Иннициализация словаря
//            while (data.size() != 6) {
//                try {
//                    throw new DataException();
//                } catch (DataException e) {
//                    data = parsData.parsInputData();
//                }
//            }
//            if (arrayData == null) {
//                throw new NullPointerException("Данные не введены");
//                }
                StringBuilder messageWrong = new StringBuilder();
                for (String string : arrayData) {
                    if (Character.isLetter(string.charAt(0))) {
                        if (string.length() == 1) {
                            if (this.gender == Gender.f || this.gender == Gender.m) {
                                try {
                                    this.gender = checkGender(string);
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
                            }
                            else if (this.firstName == null) {
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
                    } else if
                        (string.matches("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}")) {
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

        public String getLastName () { return lastName; }

    private String checkFIO(String fio) throws ExceptionFIO {
        if (fio.toLowerCase().matches("^[a-zа-яё]*$")) {
            personDt();
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
        private void personDt(String data) throws IOException {
            File filepath = new File(data.getLastName());
            try (FileWriter fileWriter = new FileWriter(filepath, true)) {
                fileWriter.append(data.toString() + "\n");
            } catch (IOException e) {
                throw e;
            }
        }
    }




