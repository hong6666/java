package thread.chapter15当观察者模式遇到Thread;

/**
 * Observable
 *
 * @author 李弘昊
 * @since 2020/5/25
 */
public interface Observable {
    /**
     * 任务生命周期的枚举类型
     */
    enum Cycle
    {
        STARTED,
        RUNNING,
        DONE,
        ERROR
    }

    /**
     * 获取当前任务的生命周期状态
     */
    Cycle getCycle();

    /**
     * 定义启动线程的方法，主要作用值为了屏蔽Thread的其他方法
     */
    void start();

    /**
     * 定义线程的打断方法，作用域start方法一样，也是为了屏蔽Thread的其他方法
     */
    void interrupt();


}
