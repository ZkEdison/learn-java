package fapiDay01;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo1 {
    public static void main(String[] args) throws IOException {
        File dat = new File("raf.dat");
        if (!dat.exists()) {
            dat.createNewFile();
        }
        RandomAccessFile raf = new RandomAccessFile(
                "raf.dat",
                "rw"
        );

        /**
         * void write(int d)
         * 写出给定的int值对应的2进制的低八位
         * 每次只写入一个字节
         */
//        raf.write(1111111111);
        System.out.println(Integer.toBinaryString(1111111111));
        /**
         * int read()
         * 读取一个字节, 并以10进制的int 型返回
         * 若返回值为-1 ,则表示读取到了额文件末尾
         */
        int d = raf.read();
        System.out.println("d = " + Integer.toBinaryString(d));
        raf.close();

    }
}
