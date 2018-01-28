package ThreadDay02;

public class SyncDemo02 {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                super.run();
                Foo.dosome();
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                super.run();
                Foo.dosome();
            }
        };
        t1.start();
        t2.start();
    }
}

class Foo {
    /**
     * 静态方法不用 new  直接 Foo.dosome
     * 即使new了 sync 也是同一份
     */
    public static synchronized void dosome() {
        try {
            Thread t = Thread.currentThread();
            System.out.println("t.getName() = " + t.getName());
            Thread.sleep(3000);
            System.out.println("t.getName() = " + t.getName() + " done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

