package ThreadDay01;

/**
 * 第二种创建线程的方式
 * 实现 Runnable 接口并重写 run 方法
 */

public class ThreadDemo02 {
    public static void main(String[] args) {
        // 单独定义任务
        MyRunnable1 r1 = new MyRunnable1();
        MyRunnable2 r2 = new MyRunnable2();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}

class MyRunnable1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            System.out.println("who are you");
        }
    }
}

class MyRunnable2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            System.out.println("good boys");
        }
    }
}

