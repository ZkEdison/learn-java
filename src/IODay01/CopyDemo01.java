package IODay01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件流复制文件
 */

public class CopyDemo01 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("copy-demo.ts");

        FileOutputStream fos = new FileOutputStream("copy-demo-001.ts");

        byte[] buf = new byte[1024 * 10];
        int len = -1;
        while ((len = fis.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        System.out.println("复制完毕");
    }
}
