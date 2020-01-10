package lhh.pattern.singletonPattern;

/**
 * @program: IdeaJava
 * @Date: 2019/12/17 15:57
 * @Author: lhh
 * @Description: 饿汉单例模式
 */
public class HungrySingletonApp {
    public static void main(String[] args)
    {
        HungrySingleton instance1 = HungrySingleton.getHungrySingletonInstance();
        HungrySingleton instance2 = HungrySingleton.getHungrySingletonInstance();
        System.out.println(instance1 == instance2);
    }
}

class HungrySingleton{
    private static HungrySingleton hungrySingletonInstance = new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getHungrySingletonInstance()
    {
        return hungrySingletonInstance;
    }
}