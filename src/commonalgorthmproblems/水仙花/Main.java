package commonalgorthmproblems.水仙花;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。例如：
 * 153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。
 * 所有的水仙花数，注意从小到大排列
 * @author 李弘昊
 * @since 2020/9/11
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(getDaffodNumbers());
    }

    /**
     * 得到水仙花数组
     * @return 数组
     */
    public static List<Integer> getDaffodNumbers() {
        List<Integer> numList = new ArrayList<>();
        for (int i = 100; i < 1000; i++) {
            if (isDaffodNumber(i)) {
                numList.add(i);
            }
        }
        Collections.sort(numList);
        return numList;
    }

    /**
     * 判断是否是水仙花
     * @param num
     * @return boolean
     */
    public static boolean isDaffodNumber(int num) {
        //把int转换为string，再转换为char数组
        char[] ch = String.valueOf(num).toCharArray();
        int result = 0;
        for (int i = 0; i < 3; i++) {
            result += Math.pow(Integer.parseInt(String.valueOf(ch[i])),3);
        }
        return (num == result);
    }

}


