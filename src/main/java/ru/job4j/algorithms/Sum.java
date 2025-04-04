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

    /**
     * алгоритм быстрой сортировки - выбираеться опорный элемент,
     * элементы < опроного эл. перебрасываються в лево
     * элементы > опорного эл. перебрасываються вправо
     * массив разделен на 2 подмасива, каждый их которых может отсортиован независимо от 2 части
     * далее этот алгоритм повторяеться в подмассивах, снова в них выбираеться опорный элемент,
     * снова деляться на 2 подмассива, так до тех пор пока эти подмосивы не превраться в отдельные элементы,
     * где сортировать уже не требуеться. На каждой итерации размер подмассива делиться на 2.
     */
    private static void quickSort(int[] array, int leftIndex, int rightIndex) {
        // Выход из рекурсии - завершить, если массив пуст или уже нечего делить
        if (array.length == 0 || leftIndex >= rightIndex) return;

        // 1. выбираем опорный элемент - pivot
        int pivot = array[(leftIndex + rightIndex) / 2];
        int leftMarkerIndex = leftIndex; // маркер отслеживающий положение каретки слева до опорного элемента
        int rightMarkerIndex = rightIndex; // маркер отслеживающий положение каретки справа до опорного элемента

        while (leftMarkerIndex <= rightMarkerIndex) {
            // 2. Перекладываем все элементы вправо влево от опорного элемента
            // Двигаем левый маркер слева направо, если элемент меньше, чем pivot
            while (array[leftMarkerIndex] < pivot) leftMarkerIndex++;
            // Двигаем правый маркер справа налево, если элемент больше, чем pivot
            while (array[rightMarkerIndex] > pivot) rightMarkerIndex--;
            // Если все неправильно и левый элемент > pivot, а правый < pivot меняем их местами
            if (leftMarkerIndex <= rightMarkerIndex) {
                int swap = array[leftMarkerIndex];
                array[leftMarkerIndex] = array[rightMarkerIndex];
                array[rightMarkerIndex] = swap;
                // сдвигаем маркеры, чтобы получить новые границы
                leftMarkerIndex++;
                rightMarkerIndex--;
            }
        }
        //3. рекурсия для сортиртировки левой и правой части
        // Если у нас есть левый подмассив (от начала до правого маркера, пришедшего в середину)
        if (leftIndex < rightMarkerIndex) quickSort(array, leftIndex, rightMarkerIndex);
        // Если у нас есть правый подмассив (от конца до левого маркера пришедшего в середину)
        if (rightIndex > leftMarkerIndex) quickSort(array, leftMarkerIndex, rightIndex);

    }

    public static void main(String[] args) {
//        Sum newSum = new Sum();
//        System.out.println(newSum.simpleSum(new int[]{1, 2, 3, 4}));
//        System.out.println(newSum.recSum(new int[]{1, 2, 3, 4}));
//
//        System.out.println(Arrays.toString(newSum.remove(new int[]{1, 2, 3, 4})));
//
//        int[] array = {1, 54, -8, 0, 71, 12, 7, 6, 12, -3, 72};
//        quickSort(array, 0, array.length-1);
//        Arrays.stream(array).forEach(System.out::println);
        int[] array = {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        System.out.println(arrayToString(array));
        quickSort1(array, 0 ,array.length - 1);

    }


    private static void quickSort1(int[] arr, int from, int to) {
        if (from < to) { // проверка есть ли что сортировать, вдруг в подмасиве всего 1 элемент и сортировать его не надо
            int divideIndex = partition(arr, from, to); // выбор опорного элемента

            printSortStep(arr, from, to, divideIndex);
            quickSort1(arr, from, divideIndex - 1); // рекурсивное вызывание для подмосивов, границы для подмасивов свои
            quickSort1(arr, divideIndex, to); // рекурсивный вызов для правого подмасива
        }
    }

    private static void printSortStep(int[] arr, int from, int to, int partitionIndex) {
        System.out.print(arrayToString(arr));
        System.out.print("\npartition at index: " + partitionIndex);
        System.out.print(", left: " + arrayToString(Arrays.copyOfRange(arr, from, partitionIndex)));
        System.out.println(", right: " + arrayToString(Arrays.copyOfRange(arr, partitionIndex, to + 1)) + "\n");
    }

    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(arr[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * ВОзвращает индекс элемента по которому идет разделение.
     * Алгоритм разделения массива на 2 подмасива.
     */
    private static int partition(int[] arr, int from, int to) {
        // переменные индекса, начало и конец массива
        int rightIndex = to;
        int lefttIndex = from;

        int pivot = arr[from]; // выбираем опорный элемент, начало массива
        while (lefttIndex <= rightIndex) {
            //движемся от начала массива к концу, до тех пор пока, в левой части, не найдем элемнт больше опрного
            while (arr[lefttIndex] < pivot) {
                lefttIndex++;
            } //жвижение индекса с конца массива, ищеться элемент, который будет меньще опорного
            while (arr[rightIndex] > pivot) {
                rightIndex--;
            }
            // после того как найден элемент больше опроного и меньще опорного, они меняються синхронно местами
            if (lefttIndex <= rightIndex) {
                swap(arr, rightIndex, lefttIndex);
                lefttIndex++;
                rightIndex--;
            }
        }

        return lefttIndex;
    }

    /**
     * Обмен двух элементов массива местами
     * если перебросили правый эл. то и левый тоже перебрасываем
     */
    private static void swap(int[] arr, int rightIndex, int lefttIndex) {
        int tmp = arr[rightIndex]; // tmp становиться rightIndex
        arr[rightIndex] = arr[lefttIndex]; // помещаем в правый массив значение из левого массива
        arr[lefttIndex] = tmp; // левый масив равен tmp
    }


}
