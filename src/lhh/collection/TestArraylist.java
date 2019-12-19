package lhh.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: IdeaJava
 * @Date: 2019/11/22 11:53
 * @Author: lhh
 * @Description:
 */
public class TestArraylist {
    public static void main(String[] args){
        List<String> mylist = new ArrayList<String>();
        mylist.add("王五");
        mylist.add("王一");
        mylist.add("王二");
        System.out.println(mylist.size());
        System.out.println(mylist.get(2));
        int x = 1;
        Integer y = x;
        int s = y;
        Integer z = Integer.valueOf(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(s);

    }
}
