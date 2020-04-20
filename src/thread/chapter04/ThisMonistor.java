package thread.chapter04;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

/**
 * @program: IdeaJava
 * @Date: 2020/4/18 10:29
 * @Author: lhh
 * @Description: 推论：使用 synchronized关键字 同步 类的不同实例方法，争抢的是同一个monitor的lock
 *                     与之关联的应用则是ThisMonitor的实例引用。
 */
public class ThisMonistor {
    public synchronized void method1() {
        System.out.println(currentThread().getName() + " enter to method1");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

/*    public synchronized void method2() {
        System.out.println(currentThread().getName() + " enter to method2");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * method1保持方法同步方式，method2采用同步代码块的方法，并且使用的是this的monitor，
     * 运行的效果完全一样
     */
    public void method2() {
        synchronized (this) {
            System.out.println(currentThread().getName() + " enter to method2");
            try {
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main (String[] args)
    {
        ThisMonistor thisMonistor = new ThisMonistor();
        new Thread(thisMonistor::method1,"T1").start();
        new Thread(thisMonistor::method2,"T2").start();
    }
}
