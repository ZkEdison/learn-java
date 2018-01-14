package Day04;

import java.util.Scanner;

/**
 * 水仙花问题
 * 打印出所有的 "水仙花数 "，所谓 "水仙花数 "是指一个三位数，其各位数字立方和等于该数本身。例如：153
 */
public class DaffodilNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入范围： 0 ~");

        int max = scanner.nextInt();
        scanner.close();
        for (int n = 10; n < max; n++) {
            // 判断n是否是
            int sum = 0;
            for (int m = n; m > 0; m/=10 ) {
                int v = m % 10;
                sum += Math.pow(v, String.valueOf(n).length());
            }
            if (n == sum) {
                System.out.println(n);
            }
        }
        
    }
}
