package ThreadDay01;

/**
 * 守护线程 又称为后台线程
 * 当一个进程中的所有前台进程都结束时, 进程就要结束
 * 若还有后台线程运行 那么后台线程会被强制结束
 */

public class ThreadDemo08 {
    public static void main(String[] args) {
        Thread rose = new Thread() {
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 10; i++) {
                    System.out.println("rose: let me go" + i);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("音效:扑通~~");
            }
        };

        Thread jack = new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    System.out.println("jack: you jump i jump");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        // 设置后台线程
        jack.setDaemon(true);

        rose.start();
        jack.start();

        System.out.println("main 线程结束!");
    }
}
