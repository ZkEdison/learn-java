package IODay01;


import java.io.FileOutputStream;
import java.io.IOException;


/**
 * 文件追加流
 *
 * 在创建FOS时若指定第二个参数 true 则追加内容
 */

public class FOSDemo02 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("fos.txt", true);

        fos.write("!!".getBytes("utf-8"));
        System.out.println("写出完毕!");
        fos.close();
    }
}
