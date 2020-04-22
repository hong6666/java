package thread.chapter05;

/**
 * @program: IdeaJava
 * @Date: 2020/4/21 18:49
 * @Author: lhh
 * @Description:
 * 1、wati方法是可中断方法，用interrupt方法将其打断后悔收到InterruptedException
 * ，同时interrupt也会被擦除。
 * 2、必须在同步方法中使用wait和notify方法，因为执行wait和notify的前提条件是
 * 必须持有同步方法的monitor的所有权。
 */
public class WaitTestApp {

    private void testWati()
    {
        try {
            this.wait();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private void testNotify()
    {
        this.notify();
    }

    private final Object MUTEX = new Object();

    private synchronized void testWaitA()
    {
        try
        {
            MUTEX.wait();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    private synchronized void testWaitB()
    {
        try
        {
            this.wait();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }


    public static void main(String[] args)
    {
        WaitTestApp waitTestApp = new WaitTestApp();
        waitTestApp.testWaitA();
    }

}
