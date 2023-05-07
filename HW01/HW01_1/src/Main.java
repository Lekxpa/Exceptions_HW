// Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

public class Main {
    public static void main(String[] args) {
        System.out.println(divide(5, 0));

        int[] arr = {1, 2, 3, 4};
        indexOut(arr, 6);

        String[] array = {"1", "2", null, "3" };
        nullPoint(array);
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Делить на ноль нельзя!");
        } else {
            return a / b;
        }
    }

    public static void indexOut(int[] arr, int ind) {
        if (ind > arr.length - 1) {
            throw new IndexOutOfBoundsException("Элемента с таким индексом не существует!");
        } else {
            System.out.println("Элемент с индексом " + ind + ": " + arr[ind]);
        }
    }

    public static void nullPoint(String[] array) {
        for (String i : array) {
            if (i == null) {
                throw new NullPointerException("Один из элементов не существует - " + i);
            }
        }
    }
}