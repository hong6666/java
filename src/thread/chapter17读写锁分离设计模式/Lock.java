package thread.chapter17读写锁分离设计模式;

/**
 * Lock
 *
 * @author 李弘昊
 * @since 2020/5/28
 */
public interface Lock {

    /**
     * 获取显示锁，没有获得锁的线程将被阻塞
     */
    void lock() throws InterruptedException;

    /**
     * 释放获取的锁
     */
    void unlock();

}
