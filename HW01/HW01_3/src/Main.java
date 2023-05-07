//Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
// и возвращающий новый массив, каждый элемент которого равен разности элементов двух входящих массивов
// в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1};
        int[] array1 = {1, 2, 3, 4};

//        int[] array = {5, 4, 3, 2, 1};  // для проверки работы
//        int[] array1 = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(arrDifference(array, array1)));
    }

    public static int[] arrDifference(int[] arr, int[] arr1) {
        if (arr.length != arr1.length) {
            throw new RuntimeException("Массивы разной длины. Расчет не возможен");
        } else {
            int[] resArray = new int[arr.length];
            for (int i = 0; i < resArray.length; i++) {
                resArray[i] = arr[i] - arr1[i];
            }
            return resArray;
        }
    }
}