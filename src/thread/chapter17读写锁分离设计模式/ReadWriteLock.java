package thread.chapter17读写锁分离设计模式;

/**
 * ReadWriteLock
 *
 * @author 李弘昊
 * @since 2020/5/28
 */
public interface ReadWriteLock {

    /**
     * reader锁
     * @return
     */
    Lock readLock();

    /**
     * write锁
     * @return
     */
    Lock writeLock();

    /**
     * 获取当前有多少线程正在执行写操作
     * @return
     */
    int getWritingWriters();

    /**
     * 获取当前有多少线程正在等待获取写入锁
     */
    int getWaitingWriters();

    /**
     * 获取当前有多少线程正在读
     */
    int getReadingReaders();

    /**
     * 工厂方法，创建ReadWriteLock
     */
    static ReadWriteLock readWriteLock()
    {
        return new ReadWriteLockImpl();
    }

    /**
     * 工厂方法，创建ReadWriteLock，并且传入preferWriter
     */
    static ReadWriteLock readWriteLock (boolean preferWriter)
    {
        return new ReadWriteLockImpl(preferWriter);
    }
}
