package thread.chapter08线程池原理及自定义线程池;

/**
 * @program: IdeaJava
 * @Date: 2020/4/28 14:26
 * @Author: lhh
 * @Description: 任务队列主要用于存放提交的Runnable任务，该Runnable是一个BlockedQueue，并有limit的限制
 */
public interface RunnableQueue {
    /**
     * 当前有新的任务进来时，首先会offer到队列中
     * @param runnable 任务
     */
    void offer(Runnable runnable);

    /**
     * 工作线程通过take方法获取Runnable
     * @return 任务Runnable
     */
    Runnable take();

    /**
     * 获取任务队列中的数量
     * @return int
     */
    int size();

}
