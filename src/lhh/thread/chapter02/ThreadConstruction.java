package lhh.thread.chapter02;

/**
 * @program: IdeaJava
 * @Date: 2019/12/23 11:53
 * @Author: lhh
 * @Description:
 */
public class ThreadConstruction {
    public static void main(String[] args) {

        Thread t1 = new Thread("t1");

        ThreadGroup group = new ThreadGroup("TestGroup");

        Thread t2 = new Thread(group,"t2");

        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();

        System.out.println("Main thread belong group:" + mainThreadGroup.getName());

        System.out.println("t1 thread belong group:" + t1.getThreadGroup().getName());

        System.out.println("t2 thread belong group:" + t2.getThreadGroup().getName());
    }
}
