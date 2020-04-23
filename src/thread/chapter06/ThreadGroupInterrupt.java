package thread.chapter06;

import java.util.concurrent.TimeUnit;

/**
 * @program: IdeaJava
 * @Date: 2020/4/23 16:00
 * @Author: lhh
 * @Description: ThreadGroup的interrupt
 * interrupt一个thread group会导致该group中所有的active线程都被
 * interrupt，也就是说该group中每一个线程的interrupt标识都被设置了，包括子group里面的
 */
public class ThreadGroupInterrupt {

    public static void main(String[] args) throws InterruptedException{
        ThreadGroup group = new ThreadGroup("TestGroup");

        new Thread(group,() ->
        {
            while(true)
            {
                try {
                    TimeUnit.MILLISECONDS.sleep(2);
                    System.out.println(1);
                }catch (InterruptedException e)
                {
                    //receive interrupt singal and clear quickly
                    break;
                }
            }
            System.out.println("t1 will exit");
        },"t1").start();

        new Thread(group,() ->
        {
            while(true)
            {
                try {
                    TimeUnit.MILLISECONDS.sleep(2);
                    System.out.println(2);
                }catch (InterruptedException e)
                {
                   break;
                }
            }
            System.out.println("t2 will exit");
        },"t2").start();

        TimeUnit.MILLISECONDS.sleep(10);
        //启动group的interrupt，中断了group里面的thread，执行break；执行输出语句
        group.interrupt();

    }

}
