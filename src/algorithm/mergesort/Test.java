package algorithm.mergesort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] a = {11, 8, 3, 9, 7, 1, 2, 5};

        mergeSort(a, 0, a.length - 1);

        System.out.println(Arrays.toString(a));
    }

    /**
     * 归并排序
     * 时间复杂度 O(nlogn)
     * 空间复杂度 O(n)
     * 稳定排序(对于值相同的元素，排序后顺序不变)
     */
    private static void mergeSort(int[] a, int l, int r) {
        //终止条件
        if (l >= r) {
            return;
        }

        int m = (l + r) / 2;
        //左边
        mergeSort(a, l, m);
        //右边
        mergeSort(a, m + 1, r);
        //合并
        merge(a, l, m + 1, r);
    }

    private static void merge(int[] array, int l, int m, int r) {
        int[] left = new int[m - l];
        int[] right = new int[r - m + 1];

        //copy左边数组
        for (int i = l; i < m; i++) {
            left[i - l] = array[i];
        }

        //copy右边数组
        for (int j = m; j <= r; j++) {
            right[j - m] = array[j];
        }

        //左边数组下标
        int i = 0;
        //右边数组下标
        int j = 0;
        //合并数组下标
        int index = l;

        while (i < left.length && j < right.length) {
            //对比左右数组的大小
            if (left[i] < right[j]) {
                array[index] = left[i];
                i++;
            } else {
                array[index] = right[j];
                j++;
            }
            index++;
        }

        //左边数组没有合并完
        while (i < left.length) {
            array[index] = left[i];
            index++;
            i++;
        }

        //右边数组没有合并完
        while (j < right.length) {
            array[index] = right[j];
            index++;
            j++;
        }
    }

}
