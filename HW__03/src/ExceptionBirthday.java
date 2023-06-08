public class ExceptionBirthday extends Exception {
    public ExceptionBirthday(){
        super("Дата рождения введена неверно. Формат должен быть: 'дд.мм.гггг'");
    }
}
