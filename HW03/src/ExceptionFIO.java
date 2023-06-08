public class ExceptionFIO extends Exception {

    String FIO;

    public ExceptionFIO(String fio) {
        this.FIO = fio;
    }

    @Override
    public String getMessage() {
        return "ФИО введены неверно. Проверьте написание!\n";
    }
}