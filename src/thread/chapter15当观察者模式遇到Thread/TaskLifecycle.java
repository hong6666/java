package thread.chapter15当观察者模式遇到Thread;

/**
 * TaskLifecycle
 *
 * @author 李弘昊
 * @since 2020/5/25
 */
public interface TaskLifecycle<T> {
    /**
     * 任务启动时会触发onStart方法
     * @param thread
     */
    void onStart(Thread thread);

    /**
     * 任务正在运行时会触发onRunning方法
     * @param thread
     */
    void onRunning(Thread thread);

    /**
     * 任务运行结束时会触发onFinish方法，其中result是任务执行结束后的结果
     * @param thread
     * @param result
     */
    void onFinish(Thread thread,T result);

    /**
     * 任务报错时会触发onError方法
     * @param thread
     * @param e
     */
    void onError(Thread thread,Exception e);

    /**
     * 生命周期接口的空实现（Adapter）
     */
    class EmptyLifecycle<T> implements TaskLifecycle<T>
    {

        @Override
        public void onStart(Thread thread) {

        }

        @Override
        public void onRunning(Thread thread) {

        }

        @Override
        public void onFinish(Thread thread, T result) {

        }

        @Override
        public void onError(Thread thread, Exception e) {

        }
    }
}
