package thread.chapter06;

/**
 * @program: IdeaJava
 * @Date: 2020/4/23 17:38
 * @Author: lhh
 * @Description: destory用于销毁ThreadGroup，该方法只是针对一个没有任何active的线程
 * group进行一次destory标记，调用该方法的直接结果是在父group中将自己移除。
 */
public class ThreadGroupDestory {

    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("TestGroup666");

        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        System.out.println("group.isDestroyed=" + group.isDestroyed());
        mainGroup.list();

        group.destroy();

        System.out.println("group.isDesstroyed=" + group.isDestroyed());
        mainGroup.list();

    }

}
