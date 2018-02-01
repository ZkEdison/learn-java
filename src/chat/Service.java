package chat;

import java.io.*;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 聊天室 服务端
 * @author zk
 */
public class Service {
    /**
     * 运行在服务端的 ServerSocket 主要负责
     * 1: 向系统申请服务端口
     *     客户端就是通过这个端口与之连接的
     * 2: 监听申请的服务端口， 当一个客户端通过该端口尝试连接时，
     *   ServerSocket会再服务端创建一个Socket与客户端建立连接
     */
    private ServerSocket server;

    /**
     * 保存所有客户端输出流的集合
     */
    private List<PrintWriter> allOut;


    /**
     * 初始化服务端
     */
    public Service() throws Exception{
        /**
         * 初始化服务端端口
         */
        server = new ServerSocket(8080);

        allOut = new ArrayList<PrintWriter>();

    }


    /**
     * 将给定的输出流存入共享集合
     * @param out
     */
    private synchronized void addOut(PrintWriter out) {
        allOut.add(out);
    }

    /**
     * 将给定的输出流从共享集合中删除
     * @param out
     */
    private synchronized void removeOut(PrintWriter out) {
        allOut.remove(out);
    }

    /**
     *将给定的消息 发送给所有客户端
     */

    private synchronized void sendMessage(String message) {
        for (PrintWriter out : allOut) {
            out.println(message);

        }
    }

    /**
     * 服务端开始启动走的方法
     */
    public void start() {
        try {
            /**
             * ServerSocket 的 accept 方法
             * 时一个阻塞方法，作用时监听服务端口
             * 直到一个客户端连接并创建一个Socket,
             * 使用该Socket即可与刚连接的客户端进行交互
             */
            while (true) {
                System.out.println("等待客户端连接");
                Socket socket = server.accept();
                System.out.println("一个客户端连接了!");
                /**
                 * 启动一个线程,来完成与客户端的交互
                 */
                ClientHandler handler = new ClientHandler(socket);

                Thread t = new Thread(handler);
                t.start();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Service service = new Service();
            service.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("启动服务器失败");
        }
    }


    /**
     * 该线程负责处理一个客户端的交互
     */
    class ClientHandler implements Runnable {

        private Socket socket;

        //客户端的地址信息
        private String host;

        //用户昵称
        private String nickName;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            /**
             * 通过Socket 可以获取远端计算机的地址信息
             *
             */
            InetAddress address = socket.getInetAddress();
            
            this.host = address.toString();
        }

        @Override
        public void run() {
            PrintWriter pw = null;
            try {
                /**
                 * Socket 提供的方法
                 * InputStream getInputStream()
                 * 该方法可以获取一个输入流
                 * 从该流读取的数据就是从远端计算机发送过来的
                 */
                InputStream in = socket.getInputStream();

                InputStreamReader isr = new InputStreamReader(in, "utf-8");

                BufferedReader br = new BufferedReader(isr);

                //先读昵称
                nickName = br.readLine();
                sendMessage(nickName + "上线了!");

                /**
                 * 通过Socket创建输出流用于将消息发送给客户端
                 */
                OutputStream out = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
                pw = new PrintWriter(osw, true);


                /**
                 * 将该客户端的输出流存入到共享集合中
                 */
                addOut(pw);


                String message = null;
                while ((message = br.readLine()) != null) {
                    sendMessage(nickName + ":" + message);
//                    pw.println(host + " : " + message);
//                    System.out.println( host + " : " + message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                /**
                 * 退出循环后 处理当前客户端断开的逻辑
                 */
                // 将该客户端的输出流从共享集合中删除
                if (pw != null) {
                    removeOut(pw);
                    sendMessage(nickName + "下线了");

                }
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
