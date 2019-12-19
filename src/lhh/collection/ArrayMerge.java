package lhh.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: IdeaJava
 * @Date: 2019/12/1 18:19
 * @Author: lhh
 * @Description: 数组合并
 */
public class ArrayMerge {
    public static void main(String[] args) {
        String a[] = new String[]{"A","E","T"};
        String b[] = {"O","R"};
        List list = new ArrayList(Arrays.asList(a));
        list.addAll(Arrays.asList(b));
        System.out.println(list.toString());
    }

}
