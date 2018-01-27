package ExceptionDay01;

/**
 * 用来测试throw 与throws
 *
 */

public class Person {
    private int age;

    public int getAge() {
        return age;
    }

    /**
     * 当一个方法中使用 throw抛出一个异常时
     * 就要在方法上使用throws 声明该类异常 的抛出以通知调用者解决
     * 只有 RuntimeException 及其子类异常使用不签字要求
     * @param age
     */
    public void setAge(int age)  throws IllegalAgeException{
        if (age < 0 || age > 100) {
            throw new IllegalAgeException("年龄不合法");
        }
        this.age = age;
    }
}
