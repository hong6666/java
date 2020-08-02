package interview.stringsomething;

import java.util.Arrays;

/**
 * SplitTest
 * split方法有两个入参，第一个参数是我们拆分的标准字符，第二个是limit的int值
 * limit限制我们需要拆分成几个元素,拆分结果里面不会有出现拆分的字段
 * @author 李弘昊
 * @since 2020/6/3
 */
public class SplitTest {

    public static void main(String[] args) {
        String s = "boo:and:foo";
        System.out.println(s);

        String str[] = s.split(":");
        System.out.println(Arrays.toString(str));

        str = s.split(":",2);
        System.out.println(Arrays.toString(str));

        str = s.split(":",4);
        System.out.println(Arrays.toString(str));

        str = s.split(":",-2);
        System.out.println(Arrays.toString(str));

        str = s.split("o");
        System.out.println(Arrays.toString(str));

        str = s.split("o",2);
        System.out.println(Arrays.toString(str));


    }
}
