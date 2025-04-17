package ru.job4j.algorithms;

import java.util.Arrays;

/**
 * Задача "Two Sum" из leetcod.
 * Дан массив целых чисел nums и целое число target,
 * вернуть индексы двух чисел, чтобы их сумма давала target.
 *
 * Вы можете предположить, что каждый вход будет иметь ровно одно решение
 * и вы не можете использовать один и тот же элемент дважды.
 *
 * Пример 1:
 *
 * Ввод: nums = [2,7,11,15], цель = 9
 * Вывод: [0,1]
 * Объяснение: поскольку nums[0] + nums[1] == 9, мы возвращаем [0, 1].
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[1];
        int sum = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) { // внешний проход по массиву
            index = nums[i]; // запоминаем индекс
            for (int j = i + 1; j < nums.length; j++) { // сравниваем все эл. с индексом который запомнили
                sum = index + nums[j];
                if (sum == target) { // базовый случай
                    arr = new int[]{i, j};
                    return arr;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {1, 6, 5, 4};
        int[] nums3 = {1, 2, 7, 4};
        int[] nums4 = {1, 2, 3, 8};
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(nums1, 9)));
        System.out.println(Arrays.toString(twoSum.twoSum(nums2, 9)));
        System.out.println(Arrays.toString(twoSum.twoSum(nums3, 9)));

        System.out.println(Arrays.toString(twoSum.twoSum(nums4, 9)));
        System.out.println(Arrays.toString(twoSum.twoSum(nums4, 4)));

    }
}
