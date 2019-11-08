package algorithm.quicksort;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] a = {11, 8, 3, 9, 7, 1, 2, 5};

        quickSort(a, 0, a.length - 1);

        System.out.println(Arrays.toString(a));
    }

    //https://juejin.im/post/5a96d6b15188255efc5f8bbd?utm_source=gold_browser_extension#heading-18
    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        //找到中间点，改点左边的值都小于array[q]，右边的值都大于array[q]
        int q = partition(array, left, right);
        quickSort(array, left, q - 1);
        quickSort(array, q + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        //默认取最右边的作为对比
        int compareValue = array[right];
        int i = left;
        int j = left;
        for (; i < right; i++) {
            if (array[i] < compareValue) {
                swap(array, i, j);
                //j是用作比较交换用的，只有交换一次，才会j++
                j++;
            }
        }

        //需要将j与right作为交换，否则值返回了j的值，数组的数据并没有更新，这样会导致后面的递归出现问题
        swap(array, j, right);

        return j;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
