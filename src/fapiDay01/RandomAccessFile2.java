package fapiDay01;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RAF 提供了方便读写基本类型数据的方法
 */
public class RandomAccessFile2 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("raf1.dat", "rw");

        // 向文件中写入int
        int max = Integer.MAX_VALUE;
        raf.writeInt(max);


        // 此时指针在最后
        System.out.println("pos" + raf.getFilePointer());
        raf.seek(0);
        System.out.println("pos" + raf.getFilePointer());
        int m = raf.readInt();
        System.out.println("m = " + m);
        raf.close();
    }
}
