package thread.chapter13深入理解voatile;

/**
 * VolatileTest
 * 当外部线程执行VolatileTest的shutdown方法的时候，VolatileTest会立刻看到started发生了变化
 * （VolatileTest工作内存中的started失效，需要到主内存中重新获取）
 * @author 李弘昊
 * @since 2020/5/21
 */
public class VolatileTest extends Thread{

    private boolean started = true;


    @Override
    public void run()
    {
        while(started)
        {
            //do work
        }
    }

    public void shutdown()
    {
        this.started = false;
    }

}
