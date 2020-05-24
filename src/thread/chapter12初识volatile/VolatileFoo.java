package thread.chapter12初识volatile;

import java.util.concurrent.TimeUnit;

/**
 * VolatileFoo
 * volatile关键字只能修饰类变量和实例变量，对于方法参数、局部变量以及实例常量，类常量
 * 都不能进行修饰。
 * @author 李弘昊
 * @since 2020/5/18
 */
public class VolatileFoo {

    final static int MAX = 5;

    /**
     * 加了volatile输出不一样
     */
    static  int init_value = 0;

    public static void main(String[] args)
    {

        //启动一个Reader线程，当发现localValue和init_vaule不同时，输出init_value被修改的信息
        new Thread(() ->
        {
            int localValue = init_value;
            while(localValue < MAX)
            {
                if (init_value != localValue)
                {
                    System.out.printf("The init_value is updated to [%d]\n",init_value);

                    localValue = init_value;
                }
            }
        },"Reader").start();

        //启动Updater线程，主要用于对init_value的修改，当local_value>=5时退出
        new Thread(() ->
        {
            int localValue = init_value;
            while (localValue < MAX)
            {
                //修改init_value
                System.out.printf("The init_value will be changed to [%d]\n",++localValue);
                init_value = localValue;
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        },"Updater").start();
    }

}
