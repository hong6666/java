package thread.chapter06;

import java.util.concurrent.TimeUnit;

/**
 * @program: IdeaJava
 * @Date: 2020/4/23 19:23
 * @Author: lhh
 * @Description: 守护线程组，将一个ThreadGroup的daemon设置为true，在线程组中没有任何
 * active线程的时候该线程组将自动销毁
 */
public class ThreadGroupDeamon {

    public static void main(String[] args) throws InterruptedException{

        ThreadGroup group1 = new ThreadGroup("Group1");
        new Thread(group1,() ->
        {
           try {
               TimeUnit.SECONDS.sleep(1);
           } catch (InterruptedException e)
           {
               e.printStackTrace();
           }
        },"group-thread1").start();

        ThreadGroup group2 = new ThreadGroup("Group2");
        new Thread(group2,() ->
        {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        },"group-thread1").start();

        group2.setDaemon(true);

        System.out.println(group2.isDestroyed());
        TimeUnit.SECONDS.sleep(3);
        System.out.println(group1.isDestroyed());
        System.out.println(group2.isDestroyed());

    }

}
