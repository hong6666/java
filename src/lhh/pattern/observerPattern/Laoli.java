package lhh.pattern.observerPattern;

/**
 * @program: IdeaJava
 * @Date: 2019/12/2 14:54
 * @Author: lhh
 * @Description:
 */
public class Laoli implements Person {

    private String name = "小李";

    public Laoli(){}

    @Override
    public void getMessage(String s) {
        System.out.println(name + "接到小美打过来的电话，电话内容是：" + s );
    }
}
