package thread.chapter09类加载过程;

/**
 * ClassInitA
 * 类的初始化class initialize
 *
 * @author 李弘昊
 * @since 2020/5/9
 */
public class ClassInitA {

    static class Parent
    {
        static int value = 10;

        static
        {
            value = 20;
        }
    }
    static class Child extends Parent
    {

        static int i = value;
    }

    public static void main(String[] args) {
        System.out.println(Child.i);
    }

}
