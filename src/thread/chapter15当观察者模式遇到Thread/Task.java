package thread.chapter15当观察者模式遇到Thread;

/**
 * Task
 *
 * @author 李弘昊
 * @since 2020/5/25
 */
@FunctionalInterface
public interface Task<T> {
    /**
     * 任务执行接口，该接口允许有返回值
     * @return
     */
    T call();
}
