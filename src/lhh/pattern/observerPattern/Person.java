package lhh.pattern.observerPattern;

/**
 * @program: IdeaJava
 * @Date: 2019/12/2 14:51
 * @Author: lhh
 * @Description:
 */
public interface Person {
    //小王和小李通过这个接口可以接收到小美发过来的消息
    void getMessage(String s);
}
