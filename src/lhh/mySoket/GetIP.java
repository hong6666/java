package lhh.mySoket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @program: IdeaJava
 * @Date: 2019/12/1 20:42
 * @Author: lhh
 * @Description:
 */
public class GetIP {
    public static void main(String[] args) {
        InetAddress address = null;
        try {
            address = InetAddress.getByName("");
        }
        catch (UnknownHostException e) {
            System.exit(2);
        }
        System.out.println(address.getHostName() + "=" + address.getHostAddress());
        System.exit(0);
    }

}
