package lhh.pattern.observerPattern;

/**
 * @program: IdeaJava
 * @Date: 2019/12/2 14:51
 * @Author: lhh
 * @Description:
 */
public class LaoWang implements Person {

    private String name = "小王";

    public LaoWang(){}

    @Override
    public void getMessage(String s) {
        System.out.println(name + "接到小美打过来的电话，电话内容是：" + s );
    }
}
