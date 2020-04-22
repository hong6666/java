package thread.chapter06;

import java.util.concurrent.TimeUnit;

/**
 * @program: IdeaJava
 * @Date: 2020/4/22 18:38
 * @Author: lhh
 * @Description: 复制Thread数组，ThreadGroup数组
 */
public class ThreadGroupEnumerateThreads {

    public static void main(String[] args) throws InterruptedException{

        ThreadGroup myGroup = new ThreadGroup("myGroup");

        Thread thread = new Thread(myGroup,() ->
        {
            while (true)
            {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        },"MyThread");
        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        Thread[] list = new Thread[mainGroup.activeCount()];
        int recurseSize = mainGroup.enumerate(list);
        System.out.println(recurseSize);

        recurseSize = mainGroup.enumerate(list,false);
        System.out.println(recurseSize);

    }
}
