package lhh.pattern.decoratorPattern;

/**
 * @program: IdeaJava
 * @Date: 2019/12/2 16:50
 * @Author: lhh
 * @Description:
 */
public class Vegetable extends Food {

    private Food basic_food;

    public Vegetable(Food basic_food) {
        this.basic_food = basic_food;
    }

    public String make() {
        return basic_food.make()+"+蔬菜";
    }

}