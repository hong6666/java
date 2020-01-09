package lhh.array数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: IdeaJava
 * @Date: 2020/1/7 15:53
 * @Author: lhh
 * @Description:
 */
public class TestMyArrayList {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        System.out.println(myArrayList.elementData.length);
        myArrayList.add("kdja");
        System.out.println(myArrayList.getSize());
        System.out.println(myArrayList.get(0));
//        myArrayList.remove(0);
        boolean a = myArrayList.remove("kdjas");
        System.out.println(a);
        System.out.println(myArrayList.getSize());
        Map ooo = new HashMap();
        int leftmove = 1 << 4;
        System.out.println(leftmove);

    }
}
