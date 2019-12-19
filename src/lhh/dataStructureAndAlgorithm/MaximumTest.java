package lhh.dataStructureAndAlgorithm;

/**
 * @program: IdeaJava
 * @Date: 2019/11/29 14:28
 * @Author: lhh
 * @Description: 该例子演示了"extends"如何使用在一般意义上的意思"extends"（类）
 * 或者"implements"（接口）。该例子中的泛型方法返回三个可比较对象的最大值。
 */
public class MaximumTest {
    public static <T extends Comparable<T>> T maximum(T x, T y, T z)
    {
        T max = x;
        if( y.compareTo( max ) > 0) max = y;
        if( z.compareTo( max ) > 0) max = z;
        return max;
    }
    public static void main(String[] args)
    {
        System.out.printf("3,4和5中最大的数为：%d\n\n",maximum(3,4,5));
        System.out.printf("6.6,5.5和2.2中最大的数为：%.2f\n\n",maximum(6.6,5.5,2.2));
        System.out.printf("pear,apple和orange中最大的数为：%s\n\n",maximum("pear","apple","orange"));
    }


}
