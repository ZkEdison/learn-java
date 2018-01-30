package chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 聊天室 客户端
 * @author  zk
 */
public class Client {
    /**
     * java.net.Socket
     * 封装了 TCP 协议 使用它就可以基于TCP协议
     * 进行网络通讯
     * Socket时运行再客户端的
     */
    private Socket socket;

    /**
     * 构造方法，用来初始化客户端
     * 实例化Socket 的时候需要传入两个参数
     * 1： 服务端地址： 通过IP地址可以找到服务的那个计算机
     * 2： 服务端端口： 通过端口可以找到服务端计算机上的服务端应用程序
     * 实例化Socket的过程就是链接的过程， 若远程计算机没有响应会抛出异常
     */
    public Client() throws Exception {
        System.out.println("正在连接服务端");
        // 指定服务端的地址和端口
        socket = new Socket("localhost", 8088);

        System.out.println("于服务建立联系");
    }

    /**
     * 启动客户端方法
     */
    public void start() {
        try {

            /**
             * Socket 提供的方法:
             * OutputStream getOutputStream
             * 获取一个字节输出流, 通过该流写出
             * 的的数据会被发送至远端计算机
             */

            // 字节输出流
            OutputStream out = socket.getOutputStream();

            OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");

            PrintWriter pw = new PrintWriter(osw, true);

            /**
             * 将字符串发送给服务端
             */
            pw.println("你好服务端");

            Scanner scanner = new Scanner(System.in);

            /**
             * 启动读取服务端发送过来消息的线程
             */
//            Thread t = new Thread(new ServerHandler());
//            t.start();
            new Thread(new ServerHandler()).start();

            while (true) {
                String msg = scanner.nextLine();
                pw.println(msg);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("客户端联系失败！！");
        }

    }

    /**
     * 该线程用来读取服务端发送过来的消息
     */
    class ServerHandler implements Runnable {

        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String message = null;
                while ((message = br.readLine()) != null) {
                    System.out.println(message);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

