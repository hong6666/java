package lhh.pattern.singletonPattern;

/**
 * @program: IdeaJava
 * @Date: 2019/12/17 16:15
 * @Author: lhh
 * @Description: 懒汉单例模式，synchronized懒汉单例模式
 */
public class LazySingletonApp {
    public static void main(String[] args)
    {
        LazySingleton instance1 = LazySingleton.getLazySingletonInstance();
        LazySingleton instance2 = LazySingleton.getLazySingletonInstance();
        System.out.println(instance1 == instance2);

        SafeLazySingleton instance3 = SafeLazySingleton.getSafeLazySingletonInstance();
        SafeLazySingleton instance4 = SafeLazySingleton.getSafeLazySingletonInstance();
        System.out.println(instance3 == instance4);
    }
}

class LazySingleton{
    private static LazySingleton lazySingletonInstance;
    private LazySingleton(){}
    public static LazySingleton getLazySingletonInstance()
    {
        if (lazySingletonInstance == null)
        {
            lazySingletonInstance = new LazySingleton();
        }
        return  lazySingletonInstance;
    }
}

//安全的懒汉模式
class SafeLazySingleton{
    private  static SafeLazySingleton safeLazySingletonInstance;
    private SafeLazySingleton(){}
    //getSafeLazySingletonInstance在方法上加了synchronized
    public static synchronized SafeLazySingleton getSafeLazySingletonInstance()
    {
        if (safeLazySingletonInstance == null)
        {
            safeLazySingletonInstance = new SafeLazySingleton();
        }
        return safeLazySingletonInstance;
    }
}