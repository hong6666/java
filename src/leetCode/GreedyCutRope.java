package leetCode;

/**
 * @program: IdeaJava
 * @Date: 2019/12/19 13:47
 * @Author: lhh
 * @Description: 你一个长度为n的绳子，请把绳子剪成m段（m，n都是整数，且都大于1）
 * 每段绳子的长度即为K[0],K[1],K[2]...K[m]。请问K[0]*k[1]..*k[m]可能的最大乘积是多少？
 */
public class GreedyCutRope {
    public static int greedyCutRope(int n)
    {
        if(n == 2) return 2;
        if(n == 3) return 3;
        if(n < 2)  return 1;
        if(n == 4) return 4;
        return 3*greedyCutRope(n-3);
    }
}
