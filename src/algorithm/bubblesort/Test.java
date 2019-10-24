package algorithm.bubblesort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        int[] a = {4, 5, 6, 1, 3, 2};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void bubbleSort(int[] a) {
        for (int i = 0, length = a.length; i < length; i++) {
            boolean hasChanged = false;
            for (int j = 0; j < length - i - 1; j++) {
                /*
                j = 0：从0开始从头开始
                j < length - i - 1：-1是为了后面的j+1不会数组越界
                                    -i是因为每一次i循环，末尾的i个数字都已经定位了，无需重复执行对比逻辑了
                 */
                if (a[j] < a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    hasChanged = true;
                }
            }
            if (!hasChanged) {
                break;
            }
        }
    }

}
