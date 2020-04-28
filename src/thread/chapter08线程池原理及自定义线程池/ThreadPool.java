package thread.chapter08线程池原理及自定义线程池;

/**
 * @program: IdeaJava
 * @Date: 2020/4/28 11:30
 * @Author: lhh
 * @Description: 一个完整的线程池应该具备如下要素：
 * 1、任务队列：用于缓存提交的任务。
 * 2、线程数量管理功能：一个线程池必须能够很好的管理和控制线程数量，线程初始数量init，
 *    线程池自动扩充是的最大线程数量max，在空闲时需要释放线程但是也要维护一定数量的活跃数量
 *    或者核心数量core。init <= core <= max;
 * 3、任务拒绝策略：线程数量已达到上限且任务队列已满，则需要有相应的拒绝策略来通知任务提交者
 * 4、线程工厂：主要用于个性化定制线程，比如将线程设置为守护线程以及设置线程名称等。
 * 5、QueueSize：任务队列主要存放提交的Runnable，但是为了防止内存溢出，需要有limit数量对其
 *    进行控制。
 * 6、Keepedalive时间：该时间主要决定线程各个重要参数自动维护的时间间隔。
 */
public interface ThreadPool {

    /**
     * 提交任务到线程池
     */
    void execute(Runnable runnable);

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 获取线程池的初始化大小
     * @return int
     */
    int getInitSize();

    /**
     * 获取线程池最大的线程数
     * @return int
     */
    int getMaxSize();

    /**
     * 获取线程池的核心线程数量
     * @return int
     */
    int getCoreSize();

    /**
     * 获取线程池中用于缓存任务队列的大小
     */
    int getQueueSize();

    /**
     * 获取线程池中活跃的线程的数量
     */
    int getAtiveCount();

    /**
     * 查看线程池是否已经被shutdown
     */
    boolean isShutdown();
}
