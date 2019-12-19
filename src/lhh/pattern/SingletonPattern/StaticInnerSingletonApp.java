package lhh.pattern.SingletonPattern;

/**
 * @program: IdeaJava
 * @Date: 2019/12/17 17:17
 * @Author: lhh
 * @Description:
 */
public class StaticInnerSingletonApp {
    public static void main(String[] args) {
        StaticInnerSingleton instance1 = StaticInnerSingleton.getInstance();
        StaticInnerSingleton instance2 = StaticInnerSingleton.getInstance();
        System.out.println(instance1 == instance2);
    }
}
class StaticInnerSingleton
{
    private StaticInnerSingleton(){}
    public static StaticInnerSingleton getInstance()
    {
        return Inner.instance;
    }
    private static class Inner
    {
        private static final StaticInnerSingleton instance = new StaticInnerSingleton();
    }

}