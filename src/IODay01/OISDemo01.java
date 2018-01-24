package IODay01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 对象输入流
 * java.io.ObjectInputStream
 * 作用时可以进行对象反序列化
 * 读取一组字节并还原对象
 *
 * OIS 读取的自己必须是由OOS将对象序列号得到的字节 否则会抛出异常
 *
 * @author  zk
 */
public class OISDemo01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("person.obj");

        ObjectInputStream ois = new ObjectInputStream(fis);

        // 对象反序列化 返回对象
        Person p = (Person) ois.readObject();

        ois.close();

        System.out.println(p);

    }



}
