import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class ParsData {
    private String firstName;
    private String lastName;
    private String middleName;
    private String birthDate;
    private String phoneNumber;
    private String gender;

    public HashMap<String, Object> parsInputData() throws IOException {
        InputData inputData = new InputData();
        String[] data = inputData.enterData();
        HashMap<String, Object> dataDic = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            if (data[0].matches("[A-Za-zА-яа-я]*$") && data[1].matches("[A-Za-zА-яа-я]*$") && data[2].matches("[A-Za-zА-яа-я]*$")) {
                this.lastName = data[0];
                this.firstName = data[1];
                this.middleName = data[2];
            }
            else {
                try {
                    throw new ExceptionFIO();
                } catch (ExceptionFIO e) {
                    throw new RuntimeException(e);
                }
            }
            if (data[3].matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}")) {
                this.birthDate = (data[3]);
            } else {
                try {
                    throw new ExceptionBirthday();
                } catch (ExceptionBirthday e) {
                    throw new RuntimeException(e);
                }
            }
            if (data[4].matches("[0-9]{11}")) {
                this.phoneNumber = (data[4]);
            } else {
                try {
                    throw new ExceptionPhone();
                } catch (ExceptionPhone e) {
                    throw new RuntimeException(e);
                }
            }
            if (data[5].length() == 1) {
                if (data[5].equals("f") || data[5].equals("m")) {
                    this.gender = data[5];
                } else {
                    try {
                        throw new ExceptionGender();
                    } catch (ExceptionGender e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
            StringBuilder sb1 = new StringBuilder();
            sb1.append("<").append(lastName).append(">")
                    .append("<").append(firstName).append(">")
                    .append("<").append(middleName).append(">")
                    .append("<").append(birthDate).append(">")
                    .append("<").append(phoneNumber).append(">")
                    .append("<").append(gender).append(">");
            System.out.println("Запись сохранена - " + sb1);

            File filepath = new File(getLastName(sb1));
            try (FileWriter fileWriter = new FileWriter(filepath, true)) {
                fileWriter.append(sb1 + "\n");

            } catch (IOException e) {
                throw e;
            }
        return dataDic;
        }

    public String getLastName(StringBuilder sb1) {
        return lastName;
    }
}


