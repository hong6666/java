package thread.chapter09类加载过程;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * ClassInitB 多线程初始化。
 * <clinit>()方法是真实存在的，但是它只能被虚拟机执行，在主动使用触发了类的初始化之后就会
 * 调用这个方法，如果有多个线程同时访问这个方法，会不会引起线程安全问题？
 * 运行下面代码，同一时间，只能有一个线程执行到静态代码块中的内容，并且静待代码块仅仅只会
 * 被执行一次
 * @author 李弘昊
 * @since 2020/5/12
 */
public class ClassInitB {

    static
    {
        try
        {
            System.out.println("The ClassInit static code block will be invoke.");
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args )
    {
        IntStream.range(0,5).forEach(i -> new Thread(ClassInit::new));
    }


}
