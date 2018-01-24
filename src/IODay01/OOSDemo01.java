package IODay01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 对象流
 * 对象流时一对高级流， 作用时方便读写java中的对象
 *
 * java.io.ObjectOutputStream
 * 对象输出流， 可以将给定的对象转换为一组字节后写出
 *
 * 当一个类需要被对象流读写， 那么该类必须实现 java,io.Serializable接口
 *
 *
 * @author zk
 */
public class OOSDemo01 {
    public static void main(String[] args) throws IOException {
        Person p = new Person();

        p.setName("小康老师");
        p.setAge(18);
        p.setGender("男");

        List<String> otherInfo = new ArrayList<String>();
        otherInfo.add("1");
        otherInfo.add("2");
        otherInfo.add("3");
        otherInfo.add("4");

        p.setOhterInfo(otherInfo);
        System.out.println(p);
        FileOutputStream fos = new FileOutputStream("person.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        /**
         * ObjectOutputStream的writeObject方法可以将
         * 给定对象转换为一组字节后写出，
         * 这些字节比该对象实际内容大，因为除了数据外还有结构等描述信息
         */

        /**
         * p 必须实现Serializable接口
         *
         * 下面代码操作过程
         * 1： oos将Person 对象转换为一组字节 对象序列化
         * 2： 再通过fos将该对象转换的字节写入到硬盘做长久保存的过程  对象持久化
         */

        oos.writeObject(p);

        oos.close();

        System.out.println("输出完毕！");
    }
}
