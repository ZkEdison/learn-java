package fapiDay01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 若想提高读写效率， 可以通过提高每次读写的数据量来减少读写次数
 */
public class CopyDemo02 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile src = new RandomAccessFile("copy-demo.ts", "r");
        RandomAccessFile desc = new RandomAccessFile("copy-demo_cp_01.ts", "rw");

        long srartTime = System.currentTimeMillis();
        /**
         * int read(byte[] date)
         * 一次尝试读取给定的字节数组总长度的字节量并存入该数组中
         * 返回值为实际读取到的自己量，若返回值为-1， 则表示本次没有读取到任何数据（文件末尾）
         */
        byte[] buf = new byte[1024 * 10]; //10kb
        int len = -1;
        /**
         * void write(byte[] d, int srart, int len)
         */
        while ((len = src.read(buf)) != -1) {
            desc.write(buf, 0, len);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("复制完成: 耗时：" + (endTime - srartTime));
        src.close();
        desc.close();
    }
}
