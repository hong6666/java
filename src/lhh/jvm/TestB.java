package lhh.jvm;

import lhh.thread.Test;

/**
 * @program: IdeaJava
 * @Date: 2019/12/20 15:15
 * @Author: lhh
 * @Description:
 */
public class TestB {

    public static TestB t1 = new TestB();

    public static TestB t2 = new TestB();

    {
        System.out.println("构造代码块");
    }
    public TestB(){
        System.out.println("构造函数");
    }
    static{
        System.out.println("静态代码块");
    }

    public static TestB t3 = new TestB();

    public static void main(String[] args){
        new TestB();
    }
}
