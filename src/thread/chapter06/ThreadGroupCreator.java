package thread.chapter06;

/**
 * @program: IdeaJava
 * @Date: 2020/4/22 17:32
 * @Author: lhh
 * @Description: 线程组group
 */
public class ThreadGroupCreator {

    public static void main(String[] args) {
        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup group1 = new ThreadGroup("Group1");
        System.out.println(group1.getParent() == currentGroup);
        //定义group2，指定group1为其父group
        ThreadGroup group2 = new ThreadGroup(group1,"Group2");
        System.out.println(group2.getParent() == group1);
    }

}
