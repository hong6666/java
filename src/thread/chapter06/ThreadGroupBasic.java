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

        /**
         * 获取group中活跃的线程，估计值
         */
        System.out.println("activeCount=" + mainGroup.activeCount());
        /**
         * 获取group中活跃的子group，估计值
         */
        System.out.println("activeGroupCount=" + mainGroup.getMaxPriority());
        /**
         * 获取group的优先级，默认情况下，group的优先级为10，在改group中，所有的线程
         * 的优先级都不能大于group的优先级
         */
        System.out.println("getMaxPriorty=" + mainGroup.getMaxPriority());
        /**
         * 获取group的名字
         */
        System.out.println("getName=" + mainGroup.getName());
        /**
         * 获取group的父group，如果父group不存在，则会返回null，
         */
        System.out.println("getParent=" + mainGroup.getParent());
        /**
         * 没有返回值，执行该方法回见group中所有的活跃线程全部输出到控制台
         */
        mainGroup.list();
        System.out.println("---------------");
        /**
         * 会判断当前group是不是给定group的父group，如果给定的group是自己也会返回true
         */
        System.out.println("parentOf=" + mainGroup.parentOf(mainGroup));
    }

}
