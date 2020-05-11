package thread.chapter09类加载过程;

/**
 * ClassInit
 *
 * @author 李弘昊
 * @since 2020/5/9
 */
public class ClassInit {

    /**
     * 静态代码块只能对后面的静态变量进行赋值，不能对其访问进行访问。
     */
    static {
//        访问x，编译不通过
//        System.out.println(x);
        x = 100;
    }
    private static int x = 10 ;

    public static void main(String[] args) {
//        静态代码块先进行赋值，后来又进行了赋值，输出10
        System.out.println(x);
    }
}
