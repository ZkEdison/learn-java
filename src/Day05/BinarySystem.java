package Day05;

import java.io.RandomAccessFile;

/**
 * 二进制
 * int 32位二进制 4 个字节
 */
public class BinarySystem {
    public static void main(String[] args) {
        int n = 45;
        System.out.println("Integer.toBinaryString(n) = " + Integer.toBinaryString(n));
        // 18进制用于缩写二进制
        int m = 0xbb;
        System.out.println("m = " + m);

        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;
        System.out.println(minValue - maxValue); // 1
        System.out.println("Integer.toBinaryString(maxValue) = " + Integer.toBinaryString(maxValue));
        double pow = Math.pow(2, 32);
        System.out.println("pow = " + Double.toString(pow));

        System.out.println("maxValue = " + maxValue );

        // 补码 最高位时1的为负数

        System.out.println("Integer.toBinaryString(0) = " + Integer.toBinaryString(-1));

        // 取反 -n = ~n + 1 (最小值失效)
        int n1 = 8;
        System.out.println("(~n +1) = " + (~n1 + 1));


        // 2进制的运算符
        // ~取反
        // >>> >> << 移位运算

        // >>>逻辑右移位运算 （不符合数学除非规律）
        // 将数字向右移动， 高位补充0 地位溢出
        int n2 = 0x6d11c99b;
        int m2 = n2 >>> 1;
        int k2 = n2 >>> 2;
        System.out.println("Integer.toBinaryString(n2) = " + Integer.toBinaryString(n2));
        System.out.println("Integer.toBinaryString(m2) = " + Integer.toBinaryString(m2));
        System.out.println("Integer.toBinaryString(k2) = " + Integer.toBinaryString(k2));

        // >> 和 >>>
        // >>高位 为1补1 高位为0 补0 保存正负号 自动向小方向取整

        // << 逻辑左移动

        // & 与操作  逻辑乘法 两个数位数与计算 （用途 截取一个数据的后8位 “掩码” mask 运算）
        // 1 & 1 = 1
        // 0 & 1 = 0
        // 1 & 0 = 0


        // 移位与掩码配合 将数据拆分

        int n3 = 0x362367de;
        int m3 = 0xff;
        int b1 = n3 & m;
        int b2 = (n3 >>> 8) & m;
        int b3 = (n3 >> 16) & m;
        int b4 = (n3 >> 24) & m;

        // 这里为什么不用字节呢?要用int?

        // | 或运算  上下兑取按最大的  加法算
        int n4 = (b1 << 24) | (b2 << 16) | (b3 << 8) | b4;

        System.out.println("m3 = " + m3); // 00000000 00000000 000000000 11111111
        System.out.println("m3 = " + Integer.toBinaryString(256));

//        byte c1 = 0xff;
    }
}
