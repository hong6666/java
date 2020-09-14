package commonalgorthmproblems.输出数组里面的2个最大值;

import java.util.Arrays;

/**
 * Main
 *
 * @author 李弘昊
 * @since 2020/9/14
 */
public class Main {

    public static void main(String[] args) {
        int[] array = {1,2,9,5,6};
        System.out.println(findMaxTowNum(array));
    }

    public static String findMaxTowNum(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j=i;j < array.length;j++) {
                if (array[i]<array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        int[] a = new int[2];
        a[0] = array[0];
        a[1] = array[1];
        return Arrays.toString(a);
    }

}
