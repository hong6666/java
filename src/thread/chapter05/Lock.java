package thread.chapter05;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @program: IdeaJava
 * @Date: 2020/4/18 16:36
 * @Author: lhh
 * @Description:
 */
public interface Lock {
    /**
     * lock()方法永远被阻塞，除非获取到了锁，和synchronized非常类似，但是该方法是可以被
     * 中断的，中断是会抛出InterruptedException异常
     * @throws InterruptedException InterruptedException
     */
    void lock() throws InterruptedException;

    /**
     * lock(long mills) 方法除了可以被中断以外， 还增加了对应的超时功能。
     * @param mills 时间
     * @throws InterruptedException InterruptedException
     * @throws TimeoutException TimeoutException
     */
    void lock(long mills) throws InterruptedException, TimeoutException;

    /**
     * unlock()方法可以用来进行锁的释放
     */
    void unlock();

    /**
     *获取当前有哪些线程被阻塞
     * @return List<Thread>
     */
    List<Thread> getBlockedThreads();
}
