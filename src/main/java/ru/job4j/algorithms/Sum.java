package ru.job4j.algorithms;

import java.util.Arrays;

public class Sum {

    public int total = 0;

    /**
     * Нахождение суммы из элеентов массива через цикл
     * @param arr
     * @return
     */
    public int simpleSum(int[] arr) {
        int total = 0;
        for (int x : arr) {
            total += x;
        }
        return total;
    }

    /**
     * рекурсивный способ нахождения суммы из элеентов массива
     */
    public int recSum(int[] arr) {
        if (arr.length > 0) {
            total += arr[0] + recSum(remove(arr));
        }
        return total;
    }

    /**
     * вычитание первого нулевого индекса массива, самый первый элемент
     */
    public int[] remove(int[] arr) {
        int[] result = new int[arr.length - 1];
        System.arraycopy(arr, 0, result, 0, 0);
        System.arraycopy(arr, 0 + 1, result, 0, arr.length - 0 - 1);
        return result;
    }

    public static void main(String[] args) {
        Sum newSum = new Sum();
        System.out.println(newSum.simpleSum(new int[]{1, 2, 3, 4}));
        System.out.println(newSum.recSum(new int[]{1, 2, 3, 4}));

        System.out.println(Arrays.toString(newSum.remove(new int[]{1, 2, 3, 4})));
    }
}
