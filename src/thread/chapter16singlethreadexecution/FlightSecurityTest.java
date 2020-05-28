package thread.chapter16singlethreadexecution;

/**
 * FlightSecurityTest
 * single thread execution单线程执行模式，使用场景：
 * 1、多线程访问资源的时候，被synchronized同步的方法总是排他性的
 * 2、对个线程对某个类的状态发生改变的时候，比如FlightSecurity的登机牌和身份证
 * 会发生改变
 * @author 李弘昊
 * @since 2020/5/27
 */
public class FlightSecurityTest {
    /**
     * 旅客线程
     */
    static class Passengers extends Thread
    {
        /**
         * 机场安检类
         */
        private final FlightSecurity flightSecurity;

        /**
         * 旅客的身份证
         */
        private final String idCard;

        /**
         * 旅客的登机牌
         */
        private final String boardingPass;

        /**
         * 构造旅客时传入身份证、登机牌以及机场安检类
         */
        public Passengers(FlightSecurity flightSecurity,String idCard,
                         String boardingPass)
        {
            this.flightSecurity = flightSecurity;
            this.idCard = idCard;
            this.boardingPass = boardingPass;
        }

        @Override
        public void run()
        {
            while (true)
            {
                //旅客不断的过安检
                flightSecurity.pass(boardingPass,idCard);
            }
        }
        public static void main(String[] args)
        {
            //定义三个旅客，身份证和登机牌首字母均相同
            final FlightSecurity flightSecurity = new FlightSecurity();
            new Passengers(flightSecurity,"A123456","AF123456").start();
            new Passengers(flightSecurity,"B123456","BF123456").start();
            new Passengers(flightSecurity,"C123456","CF123456").start();

        }

    }

}
