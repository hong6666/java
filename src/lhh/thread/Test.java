package lhh.thread;

import java.util.stream.IntStream;

/**
 * @program: IdeaJava
 * @Date: 2019/11/16 21:36
 * @Author: lhh
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        //继承Thread的匿名内部类线程创建方法
        new Thread(){//继承Thread类
            public void run(){//重写run方法
                for (int i = 0;i < 2;i++){//将要执行的代码写在run方法里
                    System.out.println("wowowwo~~~~");
                }
            }
        }.start();//开启线程


        //实现Runnable的匿名内部类的线程创建方法
        new Thread(new Runnable() {//将Run那边了的子类对象传递给Thread的构造方法
            public void run() {//重写run方法
                for (int i = 0; i < 3; i++) {//将要执行的代码写在run方法里
                    System.out.println("Runnable的匿名--->线程");
                }
            }
        }).start();//开启线程

    }
}
