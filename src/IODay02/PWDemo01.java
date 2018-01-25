package IODay02;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * 缓冲字符流
 * BufferedWriter, BufferedReader
 * 特点时可以按行读写字符串
 *
 *
 * java.io.PrintWriter
 * 具有自动行刷新的缓冲字符输出流
 * 创建pw时 ， 它一定会再内部创建BufferedWriter
 * 作为缓冲功能的叠加
 *
 * @author zk
 */
public class PWDemo01 {
    /**
     *
     * 提供了多种构造方法
     * 其中由两个可以字节对文件进行写出操作的构造方法
     *
     * PrintWriter(File file)
     * PrintWriter(String path)
     */
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("pw.txt");
        pw.println("传奇每一个");
        pw.println("一是第卅");
        pw.close();
    }
}
