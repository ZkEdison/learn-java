package IODay02;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 字符流
 * 字符流的读写单位为字符
 * 字符流都是高级流， 虽然以字符为单位读写数据 但是底层还是读写字节，
 *
 * java.io.Reader: 字符输入流的顶级父类
 * java.io.Write: 字符输出流的顶级父类
 *
 * 转换流
 * java.io.OutputStreamWriter
 * 特点时可以按照指定的字符集写出字符
 */

public class OSWDemo01 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("osw.txt");

        OutputStreamWriter osw = new OutputStreamWriter(fos);

        osw.write("l love study");

        osw.write("good");

        System.out.println("写出完毕");

        osw.close();
    }
}
