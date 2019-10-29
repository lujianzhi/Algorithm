package algorithm.insertionsort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] numbers = {3, 2, 1, 6, 5, 4};

        insertionSort(numbers, numbers.length);

        System.out.println(Arrays.toString(numbers));
    }

    /**
     * 插入排序
     */
    private static void insertionSort(int[] array, int length) {
        for (int i = 1; i < length; i++) {
            //i=1是因为index=0默认已经排序完成
            int value = array[i];
            //从i的位置从后往前遍历，对比数据的大小
            int j = i - 1;
            for (; j >= 0; j--) {
                //从后往前依次对比value的大小
                if (array[j] > value) {
                    //移动位置
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = value;
        }
    }
}
