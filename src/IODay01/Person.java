package IODay01;

import java.io.Serializable;
import java.util.List;

/**
 * 该类用于测试 作为对象流 读写对象使用
 * @author zk
 */
public class Person implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private String gender;
    private transient List<String> ohterInfo;
    // transient 北排除在外

    public Person() {
    }

    public Person(String name, int age, String gender, List<String> ohterInfo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.ohterInfo = ohterInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getOhterInfo() {
        return ohterInfo;
    }

    public void setOhterInfo(List<String> ohterInfo) {
        this.ohterInfo = ohterInfo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", ohterInfo=" + ohterInfo +
                '}';
    }
}
