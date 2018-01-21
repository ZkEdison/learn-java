package fapiDay01;

import java.io.IOException;
import java.io.RandomAccessFile;

public class CopyDemo01 {
    /**
     * 创建一个 RAF 读取
     * 读一个字节 并写入
     * 每次只读写一饿字节 所有非常慢
     */
    public static void main(String[] args) throws IOException {
        RandomAccessFile src = new RandomAccessFile("copy-demo.ts", "r");

        RandomAccessFile desc = new RandomAccessFile("copy-demo_cp.ts", "rw");
        long startTime = System.currentTimeMillis();
        int d = -1;
        while ((d = src.read()) != -1) {
            desc.write(d);
            System.out.println("正在复制！");
        }
        long endTime = System.currentTimeMillis();
        src.close();
        desc.close();
        System.out.println("复制完毕！耗时" + (endTime - startTime));

    }
}
