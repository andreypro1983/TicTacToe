package ru.gb.HW3.Task3;

//3. Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true,
//        если они одинаковые, и false в противном случае. Массивы могут быть любого типа данных,
//        но должны иметь одинаковую длину и содержать элементы одного типа. ______________________

//4. Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
//        Класс должен иметь методы getFirst(), getSecond() для получения значений пары,
//        а также переопределение метода toString(), возвращающее строковое представление пары.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("------------------------------");
        System.out.println("Task3");
        System.out.println("------------------------------");
        Integer[] arr1 = {1, 4, 3, 5, 2};
        Integer[] arr2 = new Integer[5];
        arr2[0] = 1;
        arr2[1] = 4;
        arr2[2] = 3;
        arr2[3] = 5;
        arr2[4] = 2;
        Integer[] arr3 = {4, 4, 3, 6, 2};
        Integer[] arr4 = {4, 2, 4, 3, 6, 2};

        System.out.println(compareArrays2(arr1, arr2));
        System.out.println(compareArrays2(arr2, arr3));
        System.out.println(compareArrays2(arr3, arr4));

        System.out.println(compareArrays1(arr1, arr2));
        System.out.println(compareArrays1(arr2, arr3));
//        System.out.println(compareArrays1(arr3, arr4));
        System.out.println("------------------------------");
        System.out.println("Task4");
        System.out.println("------------------------------");

        Pair<String, Integer> newPair = new Pair<>("Apple",20);
        System.out.println(newPair.getFirst());
        System.out.println(newPair.getSecond());
        System.out.println(newPair);



    }

    public static <T> boolean compareArrays1(T[] array1, T[] array2) {
        if (!(array1.length == array2.length)) {
            throw new RuntimeException("Массивы разной длины");
        }
        return Arrays.equals(array1, array2);
    }

    public static <T> boolean compareArrays2(T[] array1, T[] array2) {
        if (!(array1.length == array2.length)) {
            return false;
        }
        if (array1 == array2) {
            return true;
        }
        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
                return false;
            }
        }
        return true;
    }

}
