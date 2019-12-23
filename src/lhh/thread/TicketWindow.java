package lhh.thread;

/**
 * @program: IdeaJava
 * @Date: 2019/11/16 19:16
 * @Author: lhh
 * @Description:
 */
public class TicketWindow extends Thread {
    //柜台名称
    private final String name;

    //最对受理50笔业务
    private static final int MAX = 50;

    private int index = 1;
    /*private static int index = 1;*/

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run(){
        while(index <= MAX){
            System.out.println("柜台：" + name + "当前的号码是：" +(index++));
        }
    }

    public static void main(String[] args) {
        TicketWindow ticketWindow1 = new TicketWindow("一号出号机");
        ticketWindow1.start();

        TicketWindow ticketWindow2 = new TicketWindow("二号出号器");
        ticketWindow2.start();

        TicketWindow tickerWindow3 = new TicketWindow("三号出号机");
        tickerWindow3.start();

        TicketWindow tickerWindow4 = new TicketWindow("四号出号机");
        tickerWindow4.start();
    }


}
