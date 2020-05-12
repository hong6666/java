package thread.chapter09类加载过程;

/**
 * Singleton
 *
 * private static int x = 0;
 * private static int y ;
 * private static Singleton instance = new Singleton();
 * 在连接阶段的准备过程中，每一个类变量都被赋予了相应的初始值：
 *  x = 0, y = 0, instance = null
 * 下面跳过解析阶段，来看类的初始化阶段，初始化会为每一个类变量赋予正确的值，
 * 也就是执行<clinit>()方法的过程：
 *  x = 0, y = 0, instance = new Singleton()
 * 在new Singleton的时候会执行类的构造函数，在构造函数中对x和y进行了自增，结果为：
 *  x = 1, y = 1
 *
 * private static Singleton instance = new Singleton();
 * private static int x = 0;
 * private static int y ;
 *
 * instance = null, x = 0, y = 0
 *
 * instance = Singleton@123456, x = 1, y = 1
 *
 * instance = Singleton@123456, x = 0, y = 1
 * @author 李弘昊
 * @since 2020/4/30
 */
public class Singleton {

    private static Singleton instance = new Singleton();

    private static int x = 0;

    private static int y ;

//    private static Singleton instance = new Singleton();

    private Singleton()
    {
        x++;
        y++;
    }

    public static Singleton getInstance()
    {
        return instance;
    }

    public static void main(String[] args)
    {
        Singleton singleton = Singleton.getInstance();
        System.out.println(Singleton.x);
        System.out.println(Singleton.y);
    }

}
