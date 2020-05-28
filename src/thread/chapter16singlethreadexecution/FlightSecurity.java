package thread.chapter16singlethreadexecution;

/**
 * FlightSecurity
 * 模拟一个非线程安全的安检口类，旅客（线程）分别手持登机牌和身份证接受工作人员的检查
 * @author 李弘昊
 * @since 2020/5/27
 */
public class FlightSecurity {

    private int count = 0;
    /**
     * 登机牌
     */
    private String boardingPass = "null";
    /**
     * 身份证
     */
    private String idCard = "null";

    /**
     * 在pass方法上加入synchronized关键字这个安检口类就是线程安全的了
     */
    public void pass (String boardingPass,String idCard)
    {
        this.boardingPass = boardingPass;
        this.idCard = idCard;
        this.count++;
        check();
    }

    private void check()
    {
        //简单测试，当登机牌和身份证首字母不相同时则表示检查不通过
        if (boardingPass.charAt(0) != idCard.charAt(0))
        {
            throw new RuntimeException("=====Exception=======" + toString());
        }
    }

    @Override
    public String toString()
    {
        return "The " + count + " passengers,boardingPass [" + boardingPass +
                "],idCard [" + idCard + "]";
    }
}
