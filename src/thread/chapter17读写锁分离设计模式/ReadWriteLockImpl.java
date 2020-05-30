package thread.chapter17读写锁分离设计模式;

/**
 * ReadWriteLockImpl
 * 可以通过本ReadWriteLockImpl创建不同类型的锁
 * @author 李弘昊
 * @since 2020/5/29
 */
public class ReadWriteLockImpl implements ReadWriteLock{

    /**
     * 定义对象锁
     */
    private final Object MUTEX = new Object();

    /**
     * 当前有多少个线程正在写入
     */
    private int writingWriters = 0;

    /**
     * 当前有多少个线程正在等待写入
     */
    private int watingReaders = 0;

    /**
     * 当前有多少个现在正在读
     */
    private int readingReaders = 0;

    /**
     * read和write的偏好设置，偏向写锁
     */
    private boolean preferWriter;

    /**
     * 默认preferWriter为true
     */
    public ReadWriteLockImpl()
    {
        this(true);
    }

    /**
     * 构造ReadWriteLockImpl并且传入preferWrite
     * @param preferWriter
     */
    public ReadWriteLockImpl(boolean preferWriter)
    {
        this.preferWriter = preferWriter;
    }


    @Override
    public Lock readLock() {
        return new ReadLock(this);
    }

    @Override
    public Lock writeLock() {
        return new WriteLock(this);
    }

    /**
     * 使写入的线程数量增加
     */
    void incrementWritingWriters()
    {
        this.writingWriters++;
    }
    /**
     * 使写线程数量减少
     */
    void decrementWritingWriters()
    {
        this.writingWriters--;
    }

    /**
     * 使读的线程数量增加
     */
    void incrementReadingReaders()
    {
        this.readingReaders++;
    }
    /**
     * 使读取线程数量减少
     */
    void decrementReadingReaders()
    {
        this.readingReaders--;
    }

    /**
     * 使等待线程的数量增加
     */
    void incrementWaitingWriters()
    {
        this.watingReaders++;
    }
    /**
     * 使等待线程的数量减少
     */
    void decrementWaitingWriters()
    {
        this.watingReaders--;
    }

    @Override
    public int getWritingWriters() {
        return this.writingWriters;
    }

    @Override
    public int getWaitingWriters() {
        return this.watingReaders;
    }

    @Override
    public int getReadingReaders() {
        return this.readingReaders;
    }

    /**
     * 获取对象锁
     * @return
     */
    Object getMUTEX()
    {
        return this.MUTEX;
    }

    /**
     * 获取当前是否偏向写锁
     * @return
     */
    boolean getPreferWriter()
    {
        return this.preferWriter;
    }

    /**
     * 设置写锁偏好
     * @param preferWriter
     */
    void changePrefer(boolean preferWriter)
    {
        this.preferWriter = preferWriter;
    }
}
