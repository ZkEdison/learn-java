package IODay01;

import java.io.*;

/**
 * 缓冲流
 * 高级流
 * java.io.BfferedInputStream
 * java.io.BufferedOutputStream
 * 缓冲字节输入输出流时一对高级流，使用它们可以加快读写效率
 *
 * 高级流可以处理其他流  底层是低级流
 * 高级流是处理数据的，不同组合高级流效果可以叠加
 *
 */
public class CopyDemo02 {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("copy-demo.ts");

        BufferedInputStream bis = new BufferedInputStream(fis);

        FileOutputStream fos = new FileOutputStream("copu-demo2222.ts");

        BufferedOutputStream bos = new BufferedOutputStream(fos);
        /**
         * 缓冲流内部有一个缓冲区
         * 当bis.read 读取一个字节时， 实际上BIS会一次性读取一组字节 然后返回第一个字节
         * 当再次调用read 时， 直接从字节数组中地区第二个字节
         */
        int d = -1;
        while ((d = bis.read()) != -1) {
            bos.write(d);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("复制完毕！" + (endTime - startTime));

        bis.close();
        bos.close();
    }
}
