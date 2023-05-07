//Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
// и возвращающий новый массив, каждый элемент которого равен частному элементов двух входящих массивов
// в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя.
// Важно: При выполнении метода единственное исключение, которое пользователь
// может увидеть - RuntimeException, т.е. ваше.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1};
        int[] array1 = {1, 2, 3, 1, 0};

//        int[] array = {5, 4, 3, 2, 1};  // для проверки работы - разные массивы
//        int[] array1 = {1, 2, 3, 2};

//        int[] array = {5, 4, 3, 2, 1};  // для проверки работы
//        int[] array1 = {1, 2, 3, 2, 1};

        System.out.println(Arrays.toString(arrDiv(array, array1)));
    }

    public static int[] arrDiv(int[] arr, int[] arr1) {
        int[] resArray = new int[arr.length];
        for (int i = 0; i < resArray.length; i++) {
            if (arr.length != arr1.length) {
                throw new RuntimeException("Массивы разной длины. Расчет не возможен");
            }
            if (arr1[i] == 0){
                throw new RuntimeException("Во втором массиве есть элемент, равный 0. На ноль делить нельзя!");
            }
            else {
                resArray[i] = arr[i] / arr1[i];
            }
        }
        return resArray;
    }
}