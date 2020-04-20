package thread.chapter05;

import java.util.LinkedList;

import static java.lang.Thread.currentThread;

/**
 * @program: IdeaJava
 * @Date: 2020/4/18 11:35
 * @Author: lhh
 * @Description: 两个线程之间的通信，只有一个线程对EventQueue进行offer操作，
 * 也只有一个线程对EventQueue进行take操作，如果多个线程进行take或者offer，
 * 就会出现数据不一致的情况，其一是LinkedList中没有元素的时候仍让调用的removeFist方法
 * 其二是当LinkedList中的元素超过10个的时候仍然执行了addList方法。解决方法：
 * 将临界值的判断if更改为while，将notify更改为notifyAll.
 */
public class EventQueue {

    private final int max;

    static class Event
    {
    }

    private final LinkedList<Event> eventQueue
            = new LinkedList<>();

    private final static int DEFAULT_MAX_EVENT = 10;

    public EventQueue()
    {
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueue(int max)
    {
        this.max = max;
    }

    /**
     * offer方法会提供一个Event至队尾，如果此时队列满了，提交的线程将会被阻塞
     * @param event event
     */
    public void offer(Event event)
    {
        synchronized (eventQueue)
        {
            if (eventQueue.size() >= max)
            {
                try
                {
                    console(" the queue is full.");
                    eventQueue.wait();
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

            console(" the new event is submitted");
            eventQueue.addLast(event);
            eventQueue.notify();
        }
    }

    /**
     *  take方法从队头获取数据 ，如果队列中没有可用的数据，工作线程会被阻塞；还有
     *  一个notify方法，该方法是唤醒那些曾经执行monitor的wait方法而进入阻塞的线程
     * @return
     */
    public Event take()
    {
        synchronized(eventQueue)
        {
            if (eventQueue.isEmpty())
            {
                try {
                    console(" the queue is empty.");
                    eventQueue.wait();
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

            Event event = eventQueue.removeFirst();
            this.eventQueue.notify();
            console(" the event " +  event +" is handled.");
            return event;
        }
    }

    private void console(String message)
    {
        System.out.printf("%s:%s\n",currentThread().getName(),message);
    }
}
