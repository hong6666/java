package lhh.pattern.adapterPattern.adapterPatternEg;

/**
 * @program: IdeaJava
 * @Date: 2020/2/25 9:52
 * @Author: lhh
 * @Description:
 */

// 目标接口,我们使用的接口
interface Target {
    void request();
}

//适配器接口，不兼容，不能直接使用
class Adaptee {
    public void specificRequest()
    {
        System.out.println("适配者中的业务代码被调用！");
    }
}

//类适配器类，继承适配器拥有了specificRequest方法，实现Target目标接口，在实现中调用我们的specificRequest方法
class ClassAdapter extends Adaptee implements Target {

    public void request()
    {
        specificRequest();
    }
}

//客户端代码
public class ClassAdapterTest {
    public static void main(String[] args) {
        System.out.println("类适配器模式测试：");
        Target target = new ClassAdapter();
        target.request();
    }
}
