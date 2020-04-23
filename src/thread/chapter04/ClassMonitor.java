package thread.chapter04;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

/**
 * @program: IdeaJava
 * @Date: 2020/4/18 11:24
 * @Author: lhh
 * @Description: 得出： 用synchronized同步某个类的不同静态方法争抢的也是同一个monitor的lock。
 */
public class ClassMonitor {
    public static synchronized void method1()
    {
        System.out.println(currentThread().getName() + " enter to method1");
        try{
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static synchronized void method2() {
        System.out.println(currentThread().getName() + " enter to method2");
        try{
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        new Thread(ClassMonitor::method1,"T1").start();
        new Thread(ClassMonitor::method2,"T2").start();
    }
}