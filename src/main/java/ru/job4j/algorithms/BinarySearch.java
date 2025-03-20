package ru.job4j.algorithms;

import java.util.Arrays;

/**
 * low, hight - границы той части списка в которой происходит поиск.
 */
public class BinarySearch {

    private static int[] getListArrayOfN(int n) {
        int[] list = new int[n];
        for (int i = 1; i <= n; i++) {
             list[i - 1] = i;

        }
        System.out.println(Arrays.toString(list));
        return list;
    }

    public int binarySearch(int[] list, int item) {
        int low = 0; // начальный элемент массива
        int high = list.length - 1; // конечный элемент массива
        int mid; // середина массива
        int guess; // загаданное чилсо
        while (low <= high) { // пока эта часть не сохраниться до одного элемента
            mid = (low + high) / 2; // проверяем срединий элемент
            guess = list[mid];
            if (guess == item) { // значение найдено
                return mid;
            }
            if (guess > item) { // много
                high = mid - 1;
            } else { // мало
                low = mid + 1;
            }
        }
        return 0; // значения не существует
    }

    public static void main(String[] args) {
        int[] list = getListArrayOfN(10);
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch(list, 6));
    }
}
