package IODay01;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * java.io.FileInputStream
 * 文件输入流, 是一个低级流,用于文件中读取字节
 */

public class FISDemo01 {
    public static void main(String[] args) throws IOException {
        FileInputStream FIS = new FileInputStream("fos.txt");
        byte[] data = new byte[100];

        int len = FIS.read(data);

        String str = new String(data,0, len,"UTF-8");
        System.out.println("str = " + str);
    }
}
