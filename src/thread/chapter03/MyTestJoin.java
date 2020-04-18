package thread.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * @program: IdeaJava
 * @Date: 2020/1/17 9:27
 * @Author: lhh
 * @Description:
 */
public class MyTestJoin {
    public static void main(String[] args) throws Exception{
        Thread thread1 = MyTestJoin.create(1);
        Thread thread2 = MyTestJoin.create(2);
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0;i < 4;i++)
        {
            System.out.println("main?="+Thread.currentThread().getName() + "#" + i);
            TimeUnit.SECONDS.sleep(1);
        }

    }
    private static Thread create(int index)
    {
        Thread thread = new Thread(()->
        {
            for (int i = 0; i < 4;i++)
            {
                System.out.println("create name = "+Thread.currentThread().getName()+"#"+i);


                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        },String.valueOf(index));//线程命名
        return thread;
    }
}

