package lhh.pattern.SingletonPattern;

/**
 * @program: IdeaJava
 * @Date: 2019/12/17 16:26
 * @Author: lhh
 * @Description: 双重锁
 */
public class DoubleLockSingletonApp {
    public static void main(String[] args)
    {

    }
}
class DoubleLockSingleton{
    //使用volatile避免不必要的实例
    private static volatile DoubleLockSingleton doubleLockSingletonInstance;
    private DoubleLockSingleton(){}
    public static DoubleLockSingleton getDoubleLockSingletonInstance()
    {
        if(doubleLockSingletonInstance == null)
        {   //使用synchronized进行同步避免多线程问题
            synchronized(DoubleLockSingleton.class)
            {
                if(doubleLockSingletonInstance == null)
                {
                    return doubleLockSingletonInstance = new DoubleLockSingleton();
                }
            }
        }
        return doubleLockSingletonInstance;
    }
}