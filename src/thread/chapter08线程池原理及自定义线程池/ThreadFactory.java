package thread.chapter08线程池原理及自定义线程池;

/**
 * 线程工厂提供创建线程的接口，以便于个性化定制线程，Group，优先级，名字，守护线程等
 */
@FunctionalInterface
public interface ThreadFactory {

    Thread createThread(Runnable runnable);

}
