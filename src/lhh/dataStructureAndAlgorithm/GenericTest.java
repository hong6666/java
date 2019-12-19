package lhh.dataStructureAndAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: IdeaJava
 * @Date: 2019/11/29 14:53
 * @Author: lhh
 * @Description: 类型通配符一般是使用?代替具体的类型参数。
 * 例如 List<?> 在逻辑上是List<String>,List<Integer> 等
 * 所有List<具体类型实参>的父类。
 */
public class GenericTest {
    public static void getData(List<?> data)
    {
        System.out.println("data: " + data.get(0));
    }
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        List<Integer> age =  new ArrayList<>();
        List<Number> number = new ArrayList<>();

        name.add("icon");
        age.add(18);
        number.add(314);

        getData(name);
        getData(age);
        getData(number);
    }
}
