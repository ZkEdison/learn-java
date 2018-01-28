package ThreadDay01;

/**
 * 第一种创建线程的方式
 * 继承Thread并重写run方法来定义线程要执行的任务
 */

public class ThreadDemo01 {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();

        /**
         * 启动线程要指定start方法,而不是直接调用
         * run方法, run 方法时线程要执行的任务
         * 当线程的start方法被调用后,线程进入runnable状态
         * 一旦获取cpu时间, run方法会被自动调用
         */
        t1.start();
        t2.start();
    }
}

/**
 *  这种通过继承创建线程的方式有两点不足
 *  1: 由于java是单继承, 那么当继承了Thread后
 *      就无法再继承其他类
 *  2: 由于继承Thread后重写了run 方法规定了线程执行的任务,这导致线程与任务有一个必然耦合关系
 *      不利于进程的重用
 */


class  MyThread1 extends Thread {
    @Override
    public void run() {
//        super.run();
        for (int i = 0; i < 1000; i++) {
            System.out.println("你是谁啊");
        }
    }
}

class  MyThread2 extends Thread {
    @Override
    public void run() {
//        super.run();
        for (int i = 0; i < 1000; i++) {
            System.out.println("查水表的");
        }
    }
}