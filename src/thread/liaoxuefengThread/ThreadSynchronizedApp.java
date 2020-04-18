package thread.liaoxuefengThread;

/**
 * @program: IdeaJava
 * @Date: 2020/1/11 11:14
 * @Author: lhh
 * @Description: 线程同步问题
 */
public class ThreadSynchronizedApp {
    public static void main(String[] args) throws Exception{
        /*Thread add = new AddThread();
        Thread dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();*/


        Thread add = new Thread(()->
        {
           for(int i = 0;i < 10000;i++)
           {
               synchronized(Counter.lock)
               {
                   Counter.count++;
               }
           }
        });
        Thread dec = new Thread(()->
        {
            for(int i = 0;i < 10000;i++)
            {
                synchronized(Counter.lock)
                {
                    Counter.count--;
                }
            }
        });
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);

    }
}
class Counter
{
    public static final Object lock = new Object();
    public static int count = 0;
}

class AddThread extends Thread
{
    public void run()
    {
        for (int i = 0;i < 10000;i++)Counter.count++;
    }
}
class DecThread extends Thread
{
    public void run()
    {
        for(int i = 0;i < 10000;i++)Counter.count--;
    }
}


