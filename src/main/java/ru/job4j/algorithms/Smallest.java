package ru.job4j.algorithms;

import java.util.Arrays;

/**
 * Пример кода сортировки выбором. Это когда мы проходимся
 * по массиву находим меньший элемент и ставим его в начало.
 * Такими проходками сортируем массив по возростанию
 * getSmalest - поиск наименьщего элемента в массиве
 */
public class Smallest {

    /**
     * получить индекс меньшего элемент
     */
    public int getSmalestIndex(int[] arr) {
        int smalest = arr[0];
        int smalestIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smalest) {
                smalest = arr[i];
                smalestIndex = i;
            }
        }
        return smalestIndex;
    }

    /**
     * Сортировка выбором, от меньщего к большому.
     */
    public int[] selectionSort(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < newArr.length; i++) {
            int smalestIndex = getSmalestIndex(arr);
            newArr[i] = arr[smalestIndex];
            arr = remove(arr, smalestIndex);
        }
        return newArr;
    }

    /**
     * удаление элемента из массива. Удалить элемент можно только
     * с созданием нового массива см. операцию arraycopy.
     */
    private int[] remove(int[] arr, int index) {
        int[] result = new int[arr.length - 1];
        System.arraycopy(arr, 0, result, 0, index);
        System.arraycopy(arr, index + 1, result, index, arr.length - index - 1);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5, 3, 6, 2, 10};
        Smallest smallest = new Smallest();
        System.out.println(Arrays.toString(smallest.selectionSort(arr)));

    }
}
