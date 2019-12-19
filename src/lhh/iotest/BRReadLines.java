package lhh.iotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: IdeaJava
 * @Date: 2019/11/29 10:05
 * @Author: lhh
 * @Description:
 */
public class BRReadLines {
    public static void main(String args[]) throws IOException{
        //使用System.in创建BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'end' to quit.");
        do{
            str = br.readLine();
            System.out.println(str);
        }while(!str.equals("end"));

    }
}
