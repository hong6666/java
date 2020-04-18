package thread.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * @program: IdeaJava
 * @Date: 2019/12/24 11:16
 * @Author: lhh
 * @Description:
 */
public class ThreadTestInterrupt {
    public static void main(String[] args) {
        System.out.println("Main thread is interrupted? " + Thread.interrupted());

        Thread.currentThread().interrupt();

        System.out.println("Main thread is interrupted? " + Thread.currentThread().isInterrupted());

        try
        {
            TimeUnit.MINUTES.sleep(1);
        }catch (InterruptedException e)
        {
            System.out.println("I will be inerrupted still.");
        }
    }
}
