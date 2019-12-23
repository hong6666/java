package lhh.thread.chapter02;

/**
 * @program: IdeaJava
 * @Date: 2019/12/23 14:01
 * @Author: lhh
 * @Description: 守护线程
 */
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException{

        Thread thread = new Thread(() ->
        {
          while(true)
          {
              try
              {
                  Thread.sleep(1);
              }catch (InterruptedException e)
              {
                  e.printStackTrace();
              }
          }
        });

        thread.setDaemon(true); //将thread设置为守护线程

        thread.start();
        Thread.sleep(2_000L);
        System.out.println("Main thread finished lifecycle.");
    }
}
