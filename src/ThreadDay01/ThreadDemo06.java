package ThreadDay01;

/**
 * 线程优先级
 * 线程2的时间片分配完成听线程调度的，线程只能被动的被分配时间
 * 对于线程调度的工作不能干预
 *
 * 但是可以通过提高线程的优先级来达到尽可能干预的目的
 * 理论上 优先级越高的线程 获取cpu时间片的次数就越多
 */
public class ThreadDemo06 {

    public static void main(String[] args) {

        Thread min = new Thread() {
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 10000; i++) {
                    System.out.println("min");
                }
            }
        };

        Thread normal = new Thread() {
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 10000; i++) {
                    System.out.println("normal");
                }
            }
        };

        Thread max = new Thread() {
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 10000; i++) {
                    System.out.println("max");
                }
            }
        };

        min.setPriority(Thread.MIN_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);

        min.start();
        normal.start();
        max.start();
    }


}
