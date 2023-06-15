import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CheckData {
    public static int count = 6;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDate;
    private Integer phoneNumber;
    private String gender;

    public CheckData() {
    }
    public void CheckD(String[] dataString) throws ExceptionData {
<<<<<<< HEAD
        if (dataString == null) {
            throw new NullPointerException("Данные не введены");
        }
=======
//        if (dataString == null) {
//            throw new NullPointerException("Данные не введены");
//        }
>>>>>>> origin/master
        StringBuilder messageWrong = new StringBuilder();
        for (String string : dataString) {
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
    public String getLastName() {
        return lastName;
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
}