public class ExceptionPhone extends Exception {
        public ExceptionPhone(){
            super("Номер телефона указан неверно. \n" +
                    "Формат номера телефона должен быть - 11 цифр без разделителей 79000000000)\n");
        }
    }
