package lhh.pattern.factoryPattern;

/**
 * @program: IdeaJava
 * @Date: 2020/1/9 15:22
 * @Author: lhh
 * @Description: 工厂模式
 */
public class FactoryApp {
    public static void main(String[] args) {

        TomatoFoodFactory tomatoFactory = new TomatoFoodFactory();
        Food mytomato = tomatoFactory.createFood();
        mytomato.color();

        Food myBanana = new BananaFoodFactory().createFood();
        myBanana.color();
    }
}
interface Food
{
    void color();
}
class Tomato implements Food
{
    @Override
    public void color() {
        System.out.println("Tomato is red!");
    }
}
class Banana implements Food
{
    @Override
    public void color() {
        System.out.println("Banana is yellow！");
    }
}
interface FoodFactory
{
    Food createFood();
}
class BananaFoodFactory implements FoodFactory
{
    @Override
    public Food createFood() {
        return new Banana();
    }
}
class TomatoFoodFactory implements FoodFactory
{
    @Override
    public Food createFood() {
        return new Tomato();
    }
}