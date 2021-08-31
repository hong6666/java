package lhh.test;

import java.util.Scanner;

/**
 * @program: IdeaJava
 * @Date: 2019/11/28 22:15
 * @Author: lhh
 * @Description:
 */
public class Testaaa {
    public static void main(String[] args) {
        String s = new String("Hello World ");
        String ss = "a";
        System.out.println(Testaaa.lenghOfLastWord(ss));

    }
    public static int lenghOfLastWord(String s)
    {
        int end = s.length() - 1;

        //去掉末尾的空格
        while (end >= 0 && s.charAt(end) == ' ') end--;

        if (end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ')start--;
        return end - start;
        //test
    }
}
