package lhh.thread.chapter03;

import java.util.stream.IntStream;

/**
 * @program: IdeaJava
 * @Date: 2019/12/23 14:52
 * @Author: lhh
 * @Description: yield的本质是把当前线程重新置入抢CPU时间的”队列”,
 * 这是让发起线程让步，但是让不让还得看线程心情。和调用gc一样，回不回收得看心情
 * 不确定性大
 */
public class ThreadYield {
    public static void main(String[] args)
    {
        IntStream.range(0,10).mapToObj(ThreadYield::create).forEach(Thread::start);
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
