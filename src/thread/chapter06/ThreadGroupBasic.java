package thread.chapter06;

import java.util.concurrent.TimeUnit;

/**
 * @program: IdeaJava
 * @Date: 2020/4/22 19:22
 * @Author: lhh
 * @Description: ThreadGroup的基本操作
 */
public class ThreadGroupBasic {

    public static void main(String[] args) throws InterruptedException{

        ThreadGroup group = new ThreadGroup("group1");
        Thread thread = new Thread(group,() ->
        {
            while (true)
            {
                try
                {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        },"thread");
        thread.setDaemon(true);
        thread.start();

        TimeUnit.MILLISECONDS.sleep(1);

        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        System.out.println("activeCount=" + mainGroup.activeCount());
        System.out.println("activeGroupCount=" + mainGroup.getMaxPriority());
        System.out.println("getMaxPriorty=" + mainGroup.getMaxPriority());
        System.out.println("getName=" + mainGroup.getParent());
        mainGroup.list();

        System.out.println("---------------");
        System.out.println("parentOf=" + mainGroup.parentOf(mainGroup));
    }

}
