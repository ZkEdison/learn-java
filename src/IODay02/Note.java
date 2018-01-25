package IODay02;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 完成记事本功能
 * 要求：
 * 程序启动后，要求用户输入一个文件名，然后
 * 传教该文件，之后题诗用户开始输入内容
 * 并将用户输入 的 每一行内容都按行写入到该文件
 * 当用户输入“exit" 推出程序
 */
public class Note {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入文件名");

        String fileName = scanner.nextLine();

        FileOutputStream fos = new FileOutputStream(fileName);
        OutputStreamWriter osw = new OutputStreamWriter(fos); //转换流

        PrintWriter pw = new PrintWriter(osw, true);

        System.out.println("请输入内容");


        String line = null;

        while (true) {
            line = scanner.nextLine();
            if ("exit".equals(line)) {
                System.out.println("再见!");
                break;
            }
            pw.println(line);
        }

        pw.close();

    }
}
