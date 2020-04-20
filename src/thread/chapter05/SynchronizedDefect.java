package thread.chapter05;

import java.util.concurrent.TimeUnit;

/**
 * @program: IdeaJava
 * @Date: 2020/4/18 15:25
 * @Author: lhh
 * @Description: 同步方法syncMehtod，启用了两个线程分别调用该方法，在该方法
 * 中线程会休眠1小时。T1线程启动后主线程休眠了2毫秒，确保T1能够最先进入同步方法，
 * T2获得syncMethod的时间取决于T1何时对其释放。
 * T2因为争夺某个monitor的锁进入阻塞状态，将无法中断，虽然可以设置T2线程
 * 的interrupt标识。
 */
public class SynchronizedDefect {

    public synchronized void syncMethod()
    {
        try
        {
            TimeUnit.HOURS.sleep(1);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public  static void main(String[] args) throws InterruptedException
    {
        SynchronizedDefect defect = new SynchronizedDefect();
        Thread t1 = new Thread(defect :: syncMethod,"T1");
        //make sure the t1 started.
        t1.start();

        TimeUnit.MILLISECONDS.sleep(2);

        Thread t2 = new Thread(defect::syncMethod,"T2");
        t2.start();

        //虽然T2线程中断信号更改为true了，但是还是阻塞的。同时证实被synchronized同步的线程不可被中断
        TimeUnit.MILLISECONDS.sleep(2);
        t2.interrupt();
        //输出true
        System.out.println(t2.isInterrupted());
        //输出BLOCKED
        System.out.println(t2.getState());

    }

}
