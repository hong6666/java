package lhh.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @program: IdeaJava
 * @Date: 2020/3/3 15:39
 * @Author: lhh
 * @Description: 客户端
 */
public class Client {
    public static void main(String[] args) {
        try{
            //连接到本机的8888端口
            Socket s = new Socket("127.0.0.1",8888);
            System.out.println(s);

            //打开输出流
            OutputStream os = s.getOutputStream();

            //把输出流封装在DataOutputStream中
            DataOutputStream dos = new DataOutputStream(os);

            //使用Scanner读取控制台的输入，并发送到服务端
            Scanner sc = new Scanner(System.in);

            String str = sc.next();
            dos.writeUTF(str);

            /*//使用writeUTF发送字符串
            dos.writeUTF("lhh666");
            dos.close();*/

            /*//发送数字110到服务端
            os.write(110);
            os.close();*/
            s.close();
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
