public class ExceptionData extends Exception {
    String Mess;

    public ExceptionData(String message){
        this.Mess = message;
    }

    @Override
    public String getMessage() {
        return this.Mess;
    }
}
