package IODay02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * java.io.InputStreamReader
 * 字符输入流 ， 可以按照给定的字符集读取字符
 */

public class ISRDemo01 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("osw.txt");

        InputStreamReader isr = new InputStreamReader(fis);

        int d = -1;
        while ((d = isr.read()) != -1) {
            System.out.print((char) d);
        }
        isr.close();
    }
}
