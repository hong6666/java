package thread.chapter07;

import java.util.concurrent.TimeUnit;

/**
 * @program: IdeaJava
 * @Date: 2020/4/24 17:23
 * @Author: lhh
 * @Description: Hook线程，钩子线程
 */

/**
 * 下面例子中给java程序注入了两个Hook线程，在main线程中结束，也就是JVM中没有了活动的
 * 非守护线程，JVM进程即将退出时，两个Hook线程会被启动并且运行。
 */
public class ThreadHooK {

    public static void main(String[] args)
    {

        //为应用注入钩子线程
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                try {
                    System.out.println("The hook thread 1 is running.");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("The hook thread 1 will exit.");
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                try {
                    System.out.println("The hook thread 2 is running.");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("The hook thread 2 will exit.");
            }
        });

        System.out.println("The program will is stopping.");

    }

}
