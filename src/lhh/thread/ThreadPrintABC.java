package lhh.thread;

/**
 * @program: IdeaJava
 * @Date: 2019/12/10 16:29
 * @Author: lhh
 * @Description:
 */
public class ThreadPrintABC{
    public static void main(String[] args){
        Print print = new Print();
        MyThread myThread = new MyThread(print);
        new Thread(myThread,"A").start();
        new Thread(myThread,"B").start();
        new Thread(myThread,"C").start();
    }

}

class Print{
    private int flag = 1;
    private int count = 1;
    public int getCount(){return count;}

    public synchronized void PrintA() {
        while(flag != 1) {
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        flag = 2;
        notifyAll();
        count++;
    }

    public synchronized void PrintB() {
        while(flag != 2) {
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        flag = 3;
        notifyAll();
        count++;
    }

    public synchronized void PrintC(){
        while (flag != 3) {
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        flag = 1;
        notifyAll();
        count++;
    }
}

class MyThread implements Runnable{

    public Print print;

    public MyThread(Print print){
        this.print = print;
    }

    @Override
    public void run(){
        while(print.getCount()<14){
            if(Thread.currentThread().getName().equals("A")){
                print.PrintA();
            }
            if(Thread.currentThread().getName().equals("B")){
                print.PrintB();
            }
            if(Thread.currentThread().getName().equals("C")){
                print.PrintC();
            }
        }
    }
}



















