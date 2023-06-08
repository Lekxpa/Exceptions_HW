public class ExceptionBirth extends Exception {
    String bd;
    public ExceptionBirth(String bd) {
        this.bd = bd;
    }
    @Override
    public String getMessage() {
        return "Дата рождения введена неверно. Формат должен быть: 'дд.мм.гггг'";
    }
}
