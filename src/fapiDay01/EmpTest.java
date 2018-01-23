package fapiDay01;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class EmpTest {
    public static void main(String[] args) throws URISyntaxException, IOException {
        // 使用类加载器加载当前包中的emp.dat文件
        File file = new File("emp.dat");
        RandomAccessFile raf = new RandomAccessFile(file, "r");

        List<Emp> empList = new ArrayList<Emp>();

        String name = readString(32, raf);

        System.out.println("name = " + name);

        raf.close();

    }

    public static String readString(int len, RandomAccessFile raf) throws IOException {
        byte[] data = new byte[len];
        raf.read(data);
        return new String(data, "UTF-8").trim();
    }

}
