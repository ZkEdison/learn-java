package IODay01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 输入流  输出流
 * java.io.InputStream java.io.OutputStream
 *
 * 节点流  处理流
 *
 *
 */

public class FOSDemo01 {
    public static void main(String[] args) throws IOException {
        /**
         * 节点 输出流
         *
         * 默认创建的FOS是覆盖写操作
         * FOS会将文件数据(若有数据)全部删除 再写
         */
        FileOutputStream fos = new FileOutputStream("fos.txt");

        String str = "学习使我快乐";

        /**
         * Strubg => byte{}
         * byte getBytes()
         */
        byte[] data = str.getBytes("UTF-8");
        fos.write(data);
        fos.close();
        System.out.println("over");
    }


}
