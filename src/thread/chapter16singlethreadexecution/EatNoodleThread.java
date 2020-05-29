package thread.chapter16singlethreadexecution;

/**
 * EatNoodleThread
 *
 * @author 李弘昊
 * @since 2020/5/28
 */
public class EatNoodleThread extends Thread{

    private final String name;

    private final TablewarePair tablewarePair;

//    /**
//     * 左手的餐具
//     */
//    private final Tableware leftTool;
//
//    /**
//     * 右手的餐具
//     */
//    private final Tableware rightTool;
//
//    public EatNoodleThread(String name, Tableware leftTool, Tableware rightTool)
//    {
//        this.name = name;
//        this.leftTool = leftTool;
//        this.rightTool = rightTool;
//    }


    public EatNoodleThread(String name, TablewarePair tablewarePair)
    {
        this.name = name;
        this.tablewarePair = tablewarePair;
    }

    @Override
    public void run()
    {
        while(true)
        {
            this.eat();
        }
    }

//    private void eat()
//    {
//        synchronized(leftTool)
//        {
//            System.out.println(name + " take up " + leftTool + "(left)");
//            synchronized(rightTool)
//            {
//                System.out.println(name + " take up " + rightTool + "(right)");
//                System.out.println(name + " is eating now.");
//                System.out.println(name + " put down " + leftTool + "(left)");
//            }
//            System.out.println(name + " put down " + leftTool);
//        }
//    }

    private void eat()
    {
        synchronized (tablewarePair)
        {
            System.out.println(name + " take up " + tablewarePair.getLeftTool() + "(left)");
            System.out.println(name + " take up " + tablewarePair.getRightTool()+ "(right)");
            System.out.println(name + " is eating now.");
            System.out.println(name + " put down " + tablewarePair.getRightTool() + "(right)");
            System.out.println(name + " put down " + tablewarePair.getLeftTool() + "(left)");
        }
    }

    public static void main(String[] args) {
        Tableware fork = new Tableware("fork");
        Tableware knife = new Tableware("knife");

        TablewarePair tablewarePair = new TablewarePair(fork,knife);

        new EatNoodleThread("A",tablewarePair).start();
        new EatNoodleThread("B",tablewarePair).start();

    }

}
