package ThreadDay02;

/**
 * 多线程并发访问同一资源时, 就会形成 抢 的现象
 * 由于线程切换时机不确定, 可能导致执行代码顺序的混乱, 严重时会导致系统瘫痪
 */
public class SyncDemo01 {
    public static void main(String[] args) {
        Table table = new Table();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {

                    int bean = table.getBeans();
                    System.out.println(this.getName() + ":" + bean);

                }
            }
        };
        t1.start();
    }
}


class Table {
    private int beans = 20;

    /**
     * 当一个方法被synchronized 修饰后， 该方法
     * 为同步方法，即： 多个线程不能同时进入方法内部执行
     *
     * @return
     */
    public int getBeans() {
        synchronized (this) {
            if (this.beans == 0) {
                throw new RuntimeException("没有豆子了!" + this.beans);
            }
            Thread.yield();
            return beans--;
        }

    }

}