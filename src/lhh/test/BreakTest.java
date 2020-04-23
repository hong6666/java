package lhh.test;

/**
 * @program: IdeaJava
 * @Date: 2020/3/12 12:27
 * @Author: lhh
 * @Description:
 */
public class BreakTest {
    public static void main(String[] args) {
        /*int sum = 0;
        for (int i=1; ; i++) {
            sum = sum + i;
            if (i == 2) {
                break;
            }
        }
        System.out.println(sum);*/

        int sum = 0;
        for (int i=1; i<=10; i++) {
            System.out.println("begin i = " + i);
            if (i % 2 == 0) {
                continue; // continue语句会结束本次循环
            }
            sum = sum + i;
            System.out.println("end i = " + i);
        }
        System.out.println(sum); // 25
    }
}
