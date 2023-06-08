public class ExceptionPhone extends Exception {
    String Phonenum;

    public ExceptionPhone(String phonenum) {
        this.Phonenum = phonenum;
    }

    @Override
    public String getMessage() {
        return "Номер телефона указан неверно. + \n" +
                "Формат номера телефона - 11 цифр без разделителей 79000000000)\n";
    }
}