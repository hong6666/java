package thread.chapter05;

import java.util.concurrent.TimeUnit;

/**
 * @program: IdeaJava
 * @Date: 2020/4/18 13:53
 * @Author: lhh
 * @Description: Producer线程很快就提交了10个Event数据，此时队列满了，将会执行
 *  eventQueue的wait方法进入阻塞状态，Consumer 线程由于要处理数据，所以会花费10毫秒的
 *  时间来处理其中的一条数据，然后通知Producer线程可以继续提交数据了，如此循环往复。
 */
public class EventClient {

    public static void main(String[] args)
    {
        final EventQueue eventQueue = new EventQueue();
        new Thread(() ->
        {
            for (; ; )
            {
                eventQueue.offer(new EventQueue.Event());
            }
        },"Producer").start();

        new Thread(() ->{
            for (; ; )
            {
                eventQueue.take();
                try
                {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        },"Consumer").start();
    }
}
