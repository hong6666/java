package lhh.pattern.decoratorPattern;

/**
 * @program: IdeaJava
 * @Date: 2019/12/2 16:37
 * @Author: lhh
 * @Description:
 */
public class Food {
    private String food_name;

    public Food(){}

    public Food(String food_name){
        this.food_name = food_name;
    }

    public String make(){
        return food_name;
    }
}
