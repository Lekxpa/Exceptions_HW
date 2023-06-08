public class ExceptionGender extends Exception {
    String Gen;

    public ExceptionGender(String gen) {
        this.Gen = gen;
    }

    @Override
    public String getMessage() {
        return "Неверно указан пол. Должно быть f или m";
    }
}
