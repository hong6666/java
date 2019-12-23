package lhh.thread.chapter03;

import java.util.stream.IntStream;

/**
 * @program: IdeaJava
 * @Date: 2019/12/23 14:52
 * @Author: lhh
 * @Description:
 */
public class ThreadYield {
    public static void main(String[] args)
    {
        IntStream.range(0,2).mapToObj(ThreadYield::create).forEach(Thread::start);
    }
    private static Thread create(int index)
    {
        return new Thread(() ->
        {
            /*//注释部分
            if(index == 0)
                Thread.yield();*/
            System.out.println(index);
        });
    }
}
