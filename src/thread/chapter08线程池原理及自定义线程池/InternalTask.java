package thread.chapter08线程池原理及自定义线程池;


/**
 * InternalTask是Runnable的一个实现，主要用于线程池内部，该类会使用到RunnableQueue，
 * 然后不断地从queue中取出某个runnable，并运行runnable的run方法
 */
public class InternalTask implements Runnable{

    private final RunnableQueue runnableQueue;

    private volatile boolean running  = true;

    public InternalTask(RunnableQueue runnableQueue)
    {
        this.runnableQueue = runnableQueue;
    }

    @Override
    public void run()
    {
        //如果当前任务为running并且没有被中断，则其将不断的从queue中获取runnable，然后执行run方法
        while(running && !Thread.currentThread().isInterrupted())
        {
            Runnable task = runnableQueue.take();
            task.run();
        }
    }

    public void stop()
    {
        this.running = false;
    }
}
