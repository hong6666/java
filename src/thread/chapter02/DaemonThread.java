package thread.chapter02;

/**
 * @program: IdeaJava
 * @Date: 2019/12/23 14:01
 * @Author: lhh
 * @Description: 守护线程
 */
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException{
        //main线程开始
        Thread thread = new Thread(() ->
        {
          while(true)
          {
              System.out.println("my thread is running");
              try
              {
                  Thread.sleep(500);
              }catch (InterruptedException e)
              {
                  e.printStackTrace();
              }
          }
        });
        thread.setDaemon(true); //将thread设置为守护线程
        thread.start();//启动thread线程
        Thread.sleep(2000);
        System.out.println("Main thread finished lifecycle.");
    }
}
