package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program: IdeaJava
 * @Date: 2020/3/19 16:52
 * @Author: lhh
 * @Description:
 */
public class Java8Test {
    public static void main(String args[]){
        List<String> names1 = new ArrayList<>();
        names1.add("Google");
        names1.add("NowCoder");
        names1.add("TaoBao");
        names1.add("BaiDu");
        names1.add("SiNa");

        List<String> names2 = new ArrayList<>();
        names2.add("Google");
        names2.add("NowCoder");
        names2.add("TaoBao");
        names2.add("BaiDu");
        names2.add("SiNa");

        System.out.println(names1);
        Java8Test tester = new Java8Test();
        tester.sortUsingJava7(names1);
        System.out.println("使用java7语法: " + names1);

        tester.sortUsingJava8(names2);
        System.out.println("使用java8语法: " + names2);
    }

    //使用java7排序
    private void sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }

    //使用java8排序
    private void sortUsingJava8(List<String> names){
        Collections.sort(names,(o1,o2) -> o1.compareTo(o2));
    }

}
