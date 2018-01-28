package ThreadDay01;

/**
 * static Thread currentThread()
 * 获取当前方法的线程
 */
public class ThreadDemo04 {
    public static void main(String[] args) {
        Thread main1 = Thread.currentThread();
        long id = main1.getId();
        System.out.println("id = " + id);

        String name = main1.getName();
        System.out.println("name = " + name);

        int priority = main1.getPriority();
        System.out.println("priority = " + priority);

        boolean isAlive = main1.isAlive();
        System.out.println("isAlive = " + isAlive);

        boolean isDaemon = main1.isDaemon();
        System.out.println("isDaemon = " + isDaemon);

        boolean isInterrupted = main1.isInterrupted();
        System.out.println("isInterrupted = " + isInterrupted);
        
        System.out.println("main1 = " + main1);
    }
}
