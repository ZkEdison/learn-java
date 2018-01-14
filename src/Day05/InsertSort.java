package Day05;

import java.util.Arrays;
import java.util.Random;

/**
 * 插入排序
 * 将一个数插入到一个有序的表中
 * 当前元素前面的均为有序
 * 要插入时，从当前元素的左边往前找， 比当前元素大的均后移一个位子
 * 最后插入当前元素
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[12];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (new Random()).nextInt(100);
        }
        System.out.println(Arrays.toString(arr));

        for (int i = 1; i < arr.length; i++) {
            int temValue = arr[i]; // 当前元素
            int j;
            // 如果当前元素比前面的小 则 那个向后移动一位
            for (j = i -1 ; j >= 0 && temValue < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            // j + 1是应为 上面j--
            arr[j + 1] = temValue;
        }

        System.out.println(Arrays.toString(arr));
    }
}
