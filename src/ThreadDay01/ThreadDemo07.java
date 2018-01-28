package ThreadDay01;

import java.text.SimpleDateFormat;

/**
 * static void sleep(long ms)
 * 线程提供的静态方法sleep可以使运行该方法的线程进入阻塞状态指定毫秒
 * 超市后线程会自动回到RUNNABLE状态
 */
public class ThreadDemo07 {
    public static void main(String[] args){
        /**
         * 每秒输出当前时间
         */
        SimpleDateFormat sdf = new SimpleDateFormat("HH: mm:ss");

        while (true){
            long currentTime = System.currentTimeMillis();

            System.out.println(sdf.format(currentTime));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
