package lhh.leetCode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @program: IdeaJava
 * @Date: 2019/12/20 16:58
 * @Author: lhh
 * @Description: 在你面前有一个n阶的楼梯(n > = 100且n < 500)，你一步只能上1阶或3阶。
 * 请问计算出你可以采用多少种不同的方式爬完这个楼梯（到最后一层为爬完）。
 */
public class ClimbStairs {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger[] count = new BigInteger[n];
        count[0] = new BigInteger("1");
        count[1] = new BigInteger("1");
        count[2] = new BigInteger("2");
        for(int i = 3;i < n;i++)
        {
            count[i] = count[i-1].add(count[i-3]);
        }
        System.out.println(count[n-1]);
    }
}
