package lhh.pattern.decoratorPattern;

/**
 * @program: IdeaJava
 * @Date: 2019/12/2 16:50
 * @Author: lhh
 * @Description:
 */
public class Cream extends Food {

    private Food basic_food;

    public Cream(Food basic_food) {
        this.basic_food = basic_food;
    }

    public String make() {
        return basic_food.make()+"+奶油";
    }
}