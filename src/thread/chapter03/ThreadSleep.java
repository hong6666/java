package thread.chapter03;

import static java.lang.Thread.sleep;

/**
 * @program: IdeaJava
 * @Date: 2019/12/23 14:35
 * @Author: lhh
 * @Description:
 */
public class ThreadSleep {
    public static void main(String[] args) {
        new Thread(() ->
        {
            long startTime = System.currentTimeMillis();
            sleep(2_000L);
            long endTime = System.currentTimeMillis();
            System.out.println(String.format("Total spend %d ms",(endTime - startTime)));
        }).start();
    }

    private static void sleep(long ms)
    {
        try
        {
            Thread.sleep(ms);
        }catch(InterruptedException e)
        {
        }
    }
}
