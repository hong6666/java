package thread.chapter08线程池原理及自定义线程池;

/**
 * @program: IdeaJava
 * @Date: 2020/4/28 14:38
 * @Author: lhh
 * @Description: DenyPolicy主要用于当Queue中的runnable达到了limit上限是，决定采用何种策略
 * 通知提交者。该接口中定义了三种默认的实现。
 */
@FunctionalInterface
public interface DenyPolicy {

    void reject(Runnable runnable,ThreadPool threadPool);

    /**
     * 改拒绝策略会直接将任务丢弃
     */
    class DiscardDenyPolicy implements DenyPolicy
    {
        @Override
        public void reject(Runnable runnable,ThreadPool threadPool)
        {
            //do noting
        }
    }

    /**
     * 该拒绝策略会向任务提交者抛出异常
     */
    class AbortDenyPolicy implements DenyPolicy
    {

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            throw new RunnableDenyException("The runnable " + runnable + " will be abort.");
        }
    }

    /**
     * 该策略会使任务提交者在所提交的线程中执行任务
     */
    class RunnerDenyPolicy implements DenyPolicy
    {

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            if (!threadPool.isShutdown())
            {
                runnable.run();
            }
        }
    }

}
