package thread.chapter05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.currentThread;

/**
 * @program: IdeaJava
 * @Date: 2020/4/18 16:38
 * @Author: lhh
 * @Description: 显式锁，可以中断被阻塞的线程，使用该锁时，无比借助try finally语句来保证
 * 每次获取到锁之后都可以正常的释放。
 */
public class BooleanLock implements Lock {

    /**
     *  currentThread代表当前拥有锁的线程
     */
    private Thread currentThread;

    /**
     * locked是一个boolean开关，false代表当前锁没有被任何线程获得或者已经释放
     * true代表该锁已经被某个线程获得，该线程就是currentThread
     */
    private boolean locked = false;

    /**
     * blockedList用来存储哪些线程在获取当前线程是进入了阻塞状态
     */
    private final List<Thread> blockedList = new ArrayList<>();

    /**
     * 如果当前锁已经被某个线程获得，则将该线程加入阻塞队列，并且使当前线程wait释放
     * 对this monitor的所有权。
     * @throws InterruptedException
     */
    @Override
    public void lock() throws InterruptedException {
        synchronized (this)
        {
            while (locked)
            {
                blockedList.add(currentThread());
                this.wait();
            }
            blockedList.remove(currentThread());
            this.locked = true;
            this.currentThread = currentThread();
        }
    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {
        synchronized (this)
        {
            if (mills <= 0)
            {
                this.lock();
            } else
            {
                long remainingMills = mills;
                long endMills = currentTimeMillis() + remainingMills;
                while (locked)
                {
                    if (remainingMills <= 0)
                    {
                        throw new TimeoutException(" can not get the lock during" + mills
                                + " ms.");
                    }
                    if (!blockedList.contains(currentThread()))
                    {
                        blockedList.add(currentThread());
                    }
                    this.wait(remainingMills);
                    remainingMills = endMills - currentTimeMillis();
                }
                blockedList.remove(currentThread());
                this.locked = true;
                this.currentThread = currentThread();
            }
        }
    }

    @Override
    public void unlock() {
        synchronized (this)
        {
            if (currentThread == currentThread())
            {
                this.locked = false;
                Optional.of(currentThread().getName() + " release the lock.")
                .ifPresent(System.out::println);
                this.notifyAll();
            }
        }

    }

    @Override
    public List<Thread> getBlockedThreads() {
        return Collections.unmodifiableList(blockedList);
    }
}
