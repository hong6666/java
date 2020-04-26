package thread.chapter07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @program: IdeaJava
 * @Date: 2020/4/24 19:36
 * @Author: lhh
 * @Description: Hook线程实战，防止某个程序被重复启动，
 */
public class PreventDuplicated {

    private final static String LOCK_PATH = "D:/IdeaJava/src/thread/chapter07";

    private final static String LOCK_FILE = ".lock";

    private final static String PREMISSIONS = "rw------";

    public static void main(String[] args) throws IOException
    {

        //注入Hook线程，在程序退出时删除lock文件
        Runtime.getRuntime().addShutdownHook(new Thread(()->
        {
            System.out.println("The program received kill SIGNAL");
            getLockFile().toFile().delete();
        }));

        //检查是否存在.lock文件
        checkRunning();

        //简单模拟当前程序正在运行
        for(;;)
        {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
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

        Set<PosixFilePermission> perms = PosixFilePermissions.fromString(PREMISSIONS);

        Files.createFile(path,PosixFilePermissions.asFileAttribute(perms));

    }


    private static Path getLockFile()
    {
        return Paths.get(LOCK_PATH,LOCK_FILE);
    }
}