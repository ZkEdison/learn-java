package ExceptionDay01;

/**
 * java异常捕获机制中的 try-catch
 * try块时用来扩上可能出错的代码片段的
 * catch块是用来捕获try块中代码抛出的错误并解决
 * finally 块定义在异常捕获机制的最后
 * finally 块中的代码一定执行
 * 通常会把释放资源等操作放在finally中 ,例如关闭流
 *
 * @zk
 */
public class ExceptionDemo01 {
    public static void main(String[] args) {
        System.out.println("程序开始了");

        try {
            String str = null;
            System.out.println(str.length());

        } catch (NullPointerException e) {
            System.out.println("空指针异常" + e);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("程序结束了");
    }
}
