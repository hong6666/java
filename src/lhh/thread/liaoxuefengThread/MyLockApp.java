package lhh.thread.liaoxuefengThread;

/**
 * @program: IdeaJava
 * @Date: 2020/1/13 9:24
 * @Author: lhh
 * @Description:
 */
public class MyLockApp {
    public static void main(String[] args)
    {
        Thread dl1 = new DieLock(true);
        Thread dl2 = new DieLock(false);

        dl1.start();
        dl2.start();
    }
}
class MyLock
{
    public static final Object objA = new Object();
    public static final Object objB = new Object();
}
class DieLock extends Thread
{
    private boolean flag;

    public DieLock(boolean flag)
    {
        this.flag = flag;
    }

    @Override
    public void run()
    {
        if(flag)
        {
            synchronized(MyLock.objA)
            {
                System.out.println("if objA");
                synchronized (MyLock.objB)
                {
                    System.out.println("if objB");
                }
            }
        }else
        {
            synchronized(MyLock.objB)
            {
                System.out.println("else objB");
                synchronized(MyLock.objA)
                {
                    System.out.println("else objA");
                }
            }
        }
    }
}