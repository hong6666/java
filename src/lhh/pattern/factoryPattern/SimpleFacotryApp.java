package lhh.pattern.factoryPattern;

/**
 * @program: IdeaJava
 * @Date: 2020/1/9 14:50
 * @Author: lhh
 * @Description: 简单工厂模式
 */
public class SimpleFacotryApp {
    public static void main(String[] args) {

        Car myAutoCar = SimpleFactory.createCar("Auto");
        myAutoCar.run();

        Car myAudiCar = SimpleFactory.createCar("Audi");
        myAudiCar.run();
    }
}
interface Car
{
    void run();
}
class Auto implements  Car
{
    @Override
    public void run() {
        System.out.println("Auto runing ~~~");
    }
}
class Audi implements Car
{
    @Override
    public void run() {
        System.out.println("Audi runing ~~~");
    }
}
class SimpleFactory
{
    public static Car createCar(String s)
    {
        if (s.equals("Auto")) return new Auto();
        if (s.equals("Audi")) return new Audi();
        return null;
    }
}
