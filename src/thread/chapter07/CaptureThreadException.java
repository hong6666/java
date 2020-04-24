package thread.chapter07;

import java.util.concurrent.TimeUnit;

/**
 * @program: IdeaJava
 * @Date: 2020/4/23 19:43
 * @Author: lhh
 * @Description: 线程在执行单元中是不允许抛出checked异常，线程运行在自己的上下文中，
 * 派生它的线程将无法直接获得它运行中出现的异常信息。java提供了一个UncaughtExceptionHandler
 * 接口，当线程在运行过程中出现异常时，会回调UncaughtExceptionHandler接口，从而得知那个线程
 * 在运行时出错了
 */
public class CaptureThreadException {

    public static void main(String[] args) {

        //设置回调接口
        Thread.setDefaultUncaughtExceptionHandler((t,e) ->
        {
            System.out.println(t.getName() + " occur exception");
            e.printStackTrace();
        });

        final Thread thread = new Thread(() ->
        {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e)
            {

            }
            //unchecked异常
            System.out.println(1/0);
        },"Test-Thread");

        thread.start();
    }

}
