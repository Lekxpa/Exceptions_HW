//Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите текст: \n" +
                "(Внимание: пустую строку вводить нельзя!)");
        try {
            String result = reader.readLine();
            if(result.equals("") || result.equals(" ")) {
                throw new RuntimeException("Пустую строку вводить нельзя!");
            }
            System.out.println("Текст введен корректно!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}