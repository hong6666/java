package lhh.array数组;

import java.util.Arrays;

/**
 * @program: IdeaJava
 * @Date: 2019/11/22 11:05
 * @Author: lhh
 * @Description: 减一，数组
 */
public class MiunsOneArray {
    public static void main(String[] args){
        int num[] = {1,0,0,0};
        System.out.println(Arrays.toString(MiunsOneArray.minusOne(num)));
    }
    public static int[] minusOne(int[] digits) {
        int length = digits.length;
        //如果最后一位不是零
        if (digits[length - 1] != 0) {
            digits[length - 1] = digits[length - 1] - 1;
            return digits;
        }
        //算出末尾有多少个连续的零
        int zeroNum = 0;
        for(int i = length - 1;i >= 0; i--) {
            if (digits[i] == 0) zeroNum++;
            else break;
        }
        //第一位为1，且后面全为零
        if (zeroNum == (length - 1) && digits[0] == 1) {
            int[] array = new int[length - 1];
            for (int j = length - 2;j >= 0;j--) {
                array[j] = 9;
            }
            return array;
        }
        else {
            for (int k = zeroNum;k >= 1;k--) {
                digits[length-k] = 9; }
            digits[length - zeroNum - 1] = digits[length - zeroNum - 1] -  1;
            return digits;
        }
    }
}
