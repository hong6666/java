package thread.chapter16singlethreadexecution;

/**
 * Tableware 餐具类
 * synchronized 关键字可以保证single thread execution 但是使用不当会导致死锁的
 * 发生，比如A拿着叉子等着B放下刀子，B拿着刀子等着A放下叉子
 * @author 李弘昊
 * @since 2020/5/28
 */
public class Tableware {

    /**
     * 餐具名称
     */
    private final String toolName;

    public Tableware(String toolName)
    {
        this.toolName = toolName;
    }

    @Override
    public String toString()
    {
        return "Tool:" + toolName;
    }

}
