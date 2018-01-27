package ExceptionDay01;

/**
 * 测试异常 的抛出
 */
public class ExceptionDemo02 {
    public static void main(String[] args) {
        Person p = new Person();
        try {
            p.setAge(200);
        } catch (IllegalAgeException e) {
            e.printStackTrace();
        }
        System.out.println("age = " + p.getAge());
    }
}
