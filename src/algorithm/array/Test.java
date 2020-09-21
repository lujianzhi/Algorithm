package algorithm.array;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //[[1,4,7],[2,5,8],[3,6,9]]
        printData(transpose_867(A));

        System.out.println();

        int[][] A2 = {{1, 2, 3}, {4, 5, 6}};
        //输出：[[1,4],[2,5],[3,6]]
        printData(transpose_867(A2));

        System.out.println();
        System.out.println();

        int[] A3 = {1, 2, 5, 9, 5, 9, 5, 5, 5};
        System.out.println(majorityElement_17_10(A3));
        int[] A4 = {3, 2};
        System.out.println(majorityElement_17_10(A4));
        int[] A5 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement_17_10(A5));
    }

    /**
     * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
     * <p>
     * 示例 1：
     * <p>
     * 输入：[1,2,5,9,5,9,5,5,5]
     * 输出：5
     *  
     * <p>
     * 示例 2：
     * <p>
     * 输入：[3,2]
     * 输出：-1
     *  
     * <p>
     * 示例 3：
     * <p>
     * 输入：[2,2,1,1,1,2,2]
     * 输出：2
     */
    private static int majorityElement_17_10(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = nums.length;
        for (int i = 0; i < sum; i++) {
            Integer key = map.get(nums[i]);
            if (key == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        for (int key : map.keySet()) {
            if (map.get(key) > (sum / 2)) {
                return key;
            }
        }

        return -1;
    }

    /**
     * 给定一个矩阵 A， 返回 A 的转置矩阵。
     * <p>
     * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[[1,4,7],[2,5,8],[3,6,9]]
     * 示例 2：
     * <p>
     * 输入：[[1,2,3],[4,5,6]]
     * 输出：[[1,4],[2,5],[3,6]]
     */
    private static int[][] transpose_867(int[][] A) {
        int outLength = A.length;
        int inLength = A[0].length;
        int[][] finalArray = new int[inLength][outLength];
        for (int i = 0; i < outLength; ++i) {
            for (int j = 0; j < inLength; ++j) {
                finalArray[j][i] = A[i][j];
            }
        }

        return finalArray;
    }

    private static void printData(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            //arr[i] 表示第i+1个一维数组
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
