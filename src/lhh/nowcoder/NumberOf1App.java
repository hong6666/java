package lhh.nowcoder;

/**
 * @program: IdeaJava
 * @Date: 2020/1/3 14:19
 * @Author: lhh
 * @Description: 输入一个整数，输出该数二进制表示中1的个数。
 * 其中负数用补码表示。(计算机中负数就是用补码表示的！！！)
 */
public class NumberOf1App {
    public static int numberOf1(int n)
    {
        int count = 0;
        while(n != 0)
        {
            count++;
            n=n&(n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = -5;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(numberOf1(a));

        String str = Integer.toBinaryString(b);
        int len = str.length();
        int n = 0 ;
        for(int i = 0;i < len;i++)
        {
            if(str.charAt(i)=='1')n++;
        }
        System.out.println("number: "+ n);

        System.out.println(Integer.toBinaryString(b));
        System.out.println(numberOf1(b));

    }
}
