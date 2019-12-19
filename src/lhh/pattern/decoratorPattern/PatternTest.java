package lhh.pattern.decoratorPattern;

/**
 * @program: IdeaJava
 * @Date: 2019/12/2 16:53
 * @Author: lhh
 * @Description:
 */
public class PatternTest {
    public static void main(String[] args) {
        Food food = new Bread(new Vegetable(new Cream(new Food("香肠"))));
        System.out.println(food.make());
    }

}
