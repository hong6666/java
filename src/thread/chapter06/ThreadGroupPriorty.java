package thread.chapter06;

import java.util.concurrent.TimeUnit;

/**
 * @program: IdeaJava
 * @Date: 2020/4/23 15:44
 * @Author: lhh
 * @Description: 线程的最大优先级不能高于所在线程组的最大优先级。但是已经加入的线程之后，
 * 改变group的优先级，可以存在线程优先级大于线程组优先级的情况，但是后面加入的线程不能
 * 大于性设置的值。
 */
public class ThreadGroupPriorty {

    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("group1");
        Thread thread = new Thread(group,() ->
        {
            while (true)
            {
                try
                {
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        },"thread");
        thread.setDaemon(true);
        thread.start();

        System.out.println("group.getMaxPriority()=" + group.getMaxPriority());

        System.out.println("thread.getPriority()="+ thread.getPriority());

        //改变group的最大优先级
        group.setMaxPriority(3);

        System.out.println("group,getMaxPriority()=" + group.getMaxPriority());

        System.out.println("thread.getPriority()=" + thread.getPriority());

    }

}
