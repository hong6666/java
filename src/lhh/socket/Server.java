package lhh.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: IdeaJava
 * @Date: 2020/3/3 15:34
 * @Author: lhh
 * @Description: 服务端
 */
public class Server {
    public static void main(String[] args) {
        try{
            //服务端打开端口8888
            ServerSocket ss = new ServerSocket(8888);
            //在8888端口上监听，看是否有连接请求过来
            System.out.println("监听在端口：8888");
            Socket s = ss.accept();
            System.out.println("有连接过来" + s);

            //打开输入流
            InputStream is = s.getInputStream();

            //把输入流封装在DataInputStream
            DataInputStream dis = new DataInputStream(is);
            //使用readUTF读取字符串
            String msg = dis.readUTF();
            System.out.println(msg);
            dis.close();


            /*//读取客户端发送的数据
            int msg = is.read();
            System.out.println(msg);*/

            s.close();
            ss.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
