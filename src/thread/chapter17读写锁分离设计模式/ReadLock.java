package thread.chapter17读写锁分离设计模式;

/**
 * ReadLock 被设计为包可见
 *
 * @author 李弘昊
 * @since 2020/5/29
 */
public class ReadLock implements Lock{

    private final ReadWriteLockImpl readWriteLock;

    ReadLock(ReadWriteLockImpl readWriteLock)
    {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        //使用Mutex作为锁
        synchronized (readWriteLock.getMUTEX())
        {
            //若此时有线程在进行写操作，
            //或有写线程在等待
            //并且偏向写锁的标识为true
            //会无法获得读锁，只能被挂起
            while (readWriteLock.getWritingWriters() > 0
                    ||(readWriteLock.getPreferWriter())
                    && (readWriteLock.getWritingWriters() > 0))
            {
                readWriteLock.getMUTEX().wait();
            }
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getMUTEX())
        {
            //释放锁的郭晨就是使得当前读reading的数量减一
            //将偏向写preferWrite设置为True,可以使得writer线程获得更多的机会
            //通知唤醒与Mutex关联monitor waitset中的线程
            readWriteLock.decrementReadingReaders();
            readWriteLock.changePrefer(true);
            readWriteLock.getMUTEX().notifyAll();
        }
    }
}
