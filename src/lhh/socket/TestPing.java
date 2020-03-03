package lhh.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: IdeaJava
 * @Date: 2020/3/3 14:54
 * @Author: lhh
 * @Description: 使用java 执行ping命令
 */
public class TestPing {
    public static void main(String[] args)throws IOException {
        Process p = Runtime.getRuntime().exec("ping "+"192.168.207.1");
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(),"gbk"));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine()) != null)
        {
            if(line.length() != 0)
                sb.append(line + "\r\n");
        }
        System.out.println("本次指令返回的消息是：");
        System.out.println(sb.toString());
    }
}
