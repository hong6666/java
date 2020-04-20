package thread.chapter05;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * @program: IdeaJava
 * @Date: 2020/4/18 19:20
 * @Author: lhh
 * @Description: 多个线程用过显示锁的lock()方法争抢锁
 */
public class BooleanLockTest {

    /**
     *定义BooleanLock
     */
    private final Lock lock = new BooleanLock();

    /**
     * 使用try..finall语句块，确保lock每次都能被正确释放
     */
    public void syncMethod()
    {
        try{
            lock.lock();
            int randomInt = current().nextInt(5);
            System.out.println(currentThread() + " get the lock.");
            TimeUnit.SECONDS.sleep(randomInt);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args)
    {
        BooleanLockTest blt = new BooleanLockTest();
        /*IntStream.range(0,10)
                .mapToObj(i -> new Thread(blt::syncMethod))
                .forEach(Thread::start);*/

        //
        try {
            new Thread(blt::syncMethod,"T1").start();
            TimeUnit.MILLISECONDS.sleep(2);
            Thread t2 = new Thread(blt::syncMethod,"T2");
            t2.start();
            TimeUnit.MILLISECONDS.sleep(10);
            t2.interrupt();
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}
