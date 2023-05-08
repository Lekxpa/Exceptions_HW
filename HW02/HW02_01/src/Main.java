//Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
// и возвращает введенное значение.
// Ввод текста вместо числа не должно приводить к падению приложения, вместо этого,
// необходимо повторно запросить у пользователя ввод данных.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) {
        boolean inputFl = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(inputFl){
            System.out.print("Введите дробное число: ");
            try{
                float numFl = Float.parseFloat(reader.readLine());
                System.out.printf("Вы ввели число: %f", numFl);
                inputFl = false;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Вы ввели неверное число!");
            }
        }
    }
}