package Day05;

import java.util.Arrays;
import java.util.Random;

/**
 * 冒泡排序
 * 每次取出最大的数放在末尾
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[12];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (new Random()).nextInt(100);
        }
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSwap = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwap = true;
                }
             }
             if (!isSwap) {
                break;
             }
            System.out.println("i = " + i + '：' + Arrays.toString(arr));
        }
    }
}
