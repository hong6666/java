package lhh.jvm;

/**
 * @program: IdeaJava
 * @Date: 2019/12/20 14:19
 * @Author: lhh
 * @Description:
 */
class Father6{
    public static int a = 1;
    static{
        System.out.println("父类静态代码块");
    }
}
class Son6 extends Father6{
    public static int b = 2;
    static{
        System.out.println("子类静态代码块");
    }
}
public class OverAllTest {
    static{
        System.out.println("有Main方法的类的静态代码块");
    }
    public static void main(String[] args){
        Father6 father6;
        System.out.println("=======");

        father6 = new Father6();
        System.out.println("=======");


        System.out.println(Father6.a);
        System.out.println("=======");

        System.out.println(Son6.b);
    }
}
