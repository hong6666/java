package nowcoder;

import java.lang.reflect.Array;

/**
 * @program: IdeaJava
 * @Date: 2020/3/21 10:15
 * @Author: lhh
 * @Description: 二维数组中的查找：在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class A1 {
    public static void main(String[] args) {
        int[][] arrays = {{1,3,4,6},{2,5,7,9}};
        System.out.println(find(1,arrays));
    }

    //二位数组中arrays.length是它有多少行，arrays[0].length是第0行有多少列
    public static boolean find(int target,int[][] arrays){
        int row = 0;
        int col = arrays[0].length-1;
        while(row < arrays.length && col >= 0){
            if (target == arrays[row][col]) return true;
            if (target < arrays[row][col]) col--;
            if (target > arrays[row][col]) row++;
        }
        return false;
    }
}
