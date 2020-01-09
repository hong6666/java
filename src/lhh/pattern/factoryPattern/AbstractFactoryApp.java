package lhh.pattern.factoryPattern;

/**
 * @program: IdeaJava
 * @Date: 2020/1/9 16:22
 * @Author: lhh
 * @Description: 抽象工厂模式
 */
public class AbstractFactoryApp {
    public static void main(String[] args) {

        IceCreamFactory appleIceCreamFactory= new AppleIceCreamFactory();
        BigIceCream bigAppleIceCream = appleIceCreamFactory.createBigIceCream();
        SmallIceCream smallAppleIceCream = appleIceCreamFactory.createSmallIceCream();
        bigAppleIceCream.taste();
        smallAppleIceCream.taste();

        IceCreamFactory bananaIceCreamFactory = new BananaIceCreamFactory();
        BigIceCream bigBananaIceCream = bananaIceCreamFactory.createBigIceCream();
        SmallIceCream smallBananaIceCream = bananaIceCreamFactory.createSmallIceCream();
        bigBananaIceCream.taste();
        smallBananaIceCream.taste();
    }
}
interface BigIceCream
{
    void taste();
}
interface SmallIceCream
{
    void taste();
}
class BigAppleIceCream implements BigIceCream
{
    @Override
    public void taste() {
        System.out.println("这是苹果味冰淇淋（大份）");
    }
}
class SmallAppleIceCream implements SmallIceCream
{
    @Override
    public void taste() {
        System.out.println("这是苹果味冰淇淋（小份）");
    }
}
class BigBananaIceCream implements BigIceCream
{
    @Override
    public void taste() {
        System.out.println("这是香蕉味冰淇淋（大份）");
    }
}
class SmallBananaIceCream implements SmallIceCream
{
    @Override
    public void taste() {
        System.out.println("这是香蕉味冰淇淋（小份）");
    }
}
interface IceCreamFactory
{
    BigIceCream createBigIceCream();
    SmallIceCream createSmallIceCream();
}
class AppleIceCreamFactory implements IceCreamFactory
{
    @Override
    public BigIceCream createBigIceCream() {
        return new BigAppleIceCream();
    }
    @Override
    public SmallIceCream createSmallIceCream() {
        return new SmallAppleIceCream();
    }
}
class BananaIceCreamFactory implements IceCreamFactory
{
    @Override
    public BigIceCream createBigIceCream() {
        return new BigBananaIceCream();
    }
    @Override
    public SmallIceCream createSmallIceCream() {
        return new SmallBananaIceCream();
    }
}