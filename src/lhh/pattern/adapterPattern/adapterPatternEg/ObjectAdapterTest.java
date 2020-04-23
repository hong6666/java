package lhh.pattern.adapterPattern.adapterPatternEg;

/**
 * @program: IdeaJava
 * @Date: 2020/2/26 9:58
 * @Author: lhh
 * @Description:
 */

//对象适配器类
class ObjectAdapter implements Target
{
    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee)
    {
        this.adaptee = adaptee;
    }
    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

//客户端代码
public class ObjectAdapterTest {
    public static void main(String[] args) {
        System.out.println("对象适配器模式测试");
        Adaptee adaptee = new Adaptee();
        Target target = new ObjectAdapter(adaptee);
        target.request();
    }
}
