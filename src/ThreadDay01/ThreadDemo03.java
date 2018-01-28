package ThreadDay01;

/**
 * 使用匿名内部类来完成方式一 与方式二的线程创建
 */

public class ThreadDemo03 {
    public static void main(String[] args) {

        // 方式一
//        Thread t1 = new Thread(() -> {
//            for (int i = 0; i < 10000; i++) {
//                System.out.println("who");
//            }
//        });
//        t1.start();

        Thread t3 = new Thread() {
            @Override
            public void run() {
                super.run();
            }
        };
        t3.start();

        //方式二
//        Runnable runn = () -> {
//            for (int i = 0; i < 10000; i++) {
//                System.out.println("run");
//            }
//        };
        Runnable runn = () -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println("run");
            }
        };
        Thread t2 = new Thread(runn);
        t2.start();

    }
}


