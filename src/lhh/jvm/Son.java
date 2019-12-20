package lhh.jvm;

/**
 * @program: IdeaJava
 * @Date: 2019/12/20 14:47
 * @Author: lhh
 * @Description:
 */
class Parent{
    public Parent(){
        System.out.println("Parent的构造方法");
    }
    static{
        System.out.println("Parent的静态代码块");
    }
    {
        System.out.println("Parent的构造代码块");
    }
}
public class Son extends Parent{
    public Son(){
        System.out.println("Son的构造方法");
    }
    static{
        System.out.println("Son的静态代码块");
    }
    {
        System.out.println("Son的构造代码块");
    }
    public static void main(String[] args){
        {
            System.out.println("main方法的默认方法块1");
        }

        System.out.println("mian方法");

        new Son();

        {
            System.out.println("main方法的默认方法块2");
        }
    }
}
