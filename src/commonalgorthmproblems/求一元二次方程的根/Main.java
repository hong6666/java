package commonalgorthmproblems.求一元二次方程的根;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 编写程序求一元二次方程为ax^2 + bx + c = 0;
 * 若有两个根，请按大小顺序排序，若无根，返回null
 * 例如： 输入 1 1 6
 * 输出 2 -3
 * @author 李弘昊
 * @since 2020/9/11
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);
        double[] result = getX1X2(a,b,c);
        if (result == null) {
            System.out.println(Arrays.toString(result));
        }else {
            Arrays.sort(result);
            System.out.println(Arrays.toString(result));
        }


    }

    public static double[] getX1X2(int a, int b, int c) {
        if ((b*b-4*a*c)<0 || a == 0) {
            return null;
        } else {
            double x1 = (-b + Math.sqrt(b*b-4*a*c))/(2*a);
            double x2 = (-b - Math.sqrt(b*b-4*a*c))/(2*a);
            if (x1 == x2) {
                return new double[]{x1};
            } else {
                return new double[]{x1,x2};
            }
        }
    }

}
