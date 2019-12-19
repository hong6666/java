package lhh.iotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: IdeaJava
 * @Date: 2019/11/29 9:56
 * @Author: lhh
 * @Description:从控制台读取多字符输入
 */
public class BRRead {
    public static void main(String args[]) throws IOException {
        char c;
        //使用System.in创建BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("输入字符，按下'q'退出。");
        do{
            c = (char) br.read();
            System.out.println(c);
        }while(c != 'q');
    }
}
