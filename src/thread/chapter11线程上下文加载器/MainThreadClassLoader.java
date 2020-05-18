package thread.chapter11线程上下文加载器;

import static java.lang.Thread.currentThread;

/**
 * MainThreadClassLoader
 *
 * @author 李弘昊
 * @since 2020/5/18
 */
public class MainThreadClassLoader {

    public static void main(String[] args)
    {
        System.out.println("## "  + currentThread().getContextClassLoader());
    }

}
