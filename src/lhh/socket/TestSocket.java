package lhh.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @program: IdeaJava
 * @Date: 2020/3/3 14:46
 * @Author: lhh
 * @Description: 获取本机IP地址
 */
public class TestSocket {
    public static void main(String[] args)throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();
        String ip = host.getHostAddress();
        System.out.print("本级IP地址" + ip);
    }
}
