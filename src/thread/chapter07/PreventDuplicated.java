package thread.chapter07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

/**
 * @program: IdeaJava
 * @Date: 2020/4/24 19:36
 * @Author: lhh
 * @Description: Hook线程实战，防止某个程序被重复启动，
 * 钩子线程hook，只有在收到退出信号的时候会被执行。可以执行一些资源释放的工作
 * ，如关闭文件句柄、socket连接、数据库connection等。尽量不要在Hook线程中执行一些
 * 耗时非常长的操作，会导致程序迟迟不能退出。切记如果强制杀死线程，进程将不会收到
 * 任何中断信号。
 */
public class PreventDuplicated {

    private final static String LOCK_PATH = "D:/IdeaJava/src/thread/chapter07";

    private final static String LOCK_FILE = ".lock";

    private final static String PERMISSIONS = "rw------";

    public static void main(String[] args) throws IOException
    {

        //注入Hook线程，在程序退出时删除lock文件
        Runtime.getRuntime().addShutdownHook(new Thread(() ->
        {
            System.out.println("The program received kill SIGNAL");
            getLockFile().toFile().delete();
        }));

        //检查是否存在.lock文件
        checkRunning();

        //简单模拟当前程序正在运行
        for(; ; )
        {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("program is running");
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }

    private static void checkRunning() throws IOException
    {
        Path path = getLockFile();
        if (path.toFile().exists())
        {
            throw new RuntimeException("The program already running");
        }

        Files.createFile(path);

    }


    private static Path getLockFile()
    {
        return Paths.get(LOCK_PATH,LOCK_FILE);
    }
}
