package thread.chapter14单例模式;

/**
 * Singleton_Holder 借助类加载的特点
 * final不允许被继承
 * 在Singleton_Holder类中没有instance的静态成员，而是将其放到了静态内部类Holder之中，
 * 在Singleton_Holder类的初始化过程中不会创建Singleton_Holder的实例，Holder类中定义了
 * Singleton_Holder的静态变量，并且直接进行了实例化，当Holder被主动引用的时候会创建Singleton_Holder
 * 的实例，Singleton_Holder实例的创建过程在java程序编译时期被收集至类初始化方法中，该方法
 * 是同步方法，可以保证内存的可见性，jvm指令的顺序性和原子性，是目前单例设计最好的设计之一
 * 使用比较广泛的设计之一
 * @author 李弘昊
 * @since 2020/5/24
 */
public final class Singleton_Holder {
    //实例变量
    private byte[] data = new byte[1024];

    private Singleton_Holder()
    {
    }
    /**
     * 在静态内部类中持有Singleton的实例，并且可被直接初始化
     */
    private static class Holder
    {
        private static Singleton_Holder instance = new Singleton_Holder();
    }

    public static Singleton_Holder getInstance()
    {
        return  Holder.instance;
    }


}
