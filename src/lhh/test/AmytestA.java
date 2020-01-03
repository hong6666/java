package lhh.test;

import java.util.Scanner;

/**
 * @program: IdeaJava
 * @Date: 2020/1/3 10:46
 * @Author: lhh
 * @Description: 递归输入字符串每次递归去掉第一个字符和最后一个字符，比较第一个字符和最后一个字符，若相等递归，不相等返回0；
 * 直到最后一个或没有字符返回一，依次相乘。
 */
public class AmytestA {
    static Scanner input=new Scanner(System.in);
    static int jisuan(String a) {
        int x=a.length();
        if(x==0||x==1)return 1;
        if(a.charAt(0)==a.charAt(x-1)) {
            a=a.substring(1,x-1);
            return 1*jisuan(a);
        }
        else return 0;
    }
    public static void main(String[]args) {
        String a;
        a=input.next();
        if(jisuan(a)==1) {
            System.out.println("是");
        }
        else
            System.out.println("否");
    }
}
