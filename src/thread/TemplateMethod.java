package thread;

/**
 * @program: IdeaJava
 * @Date: 2019/11/12 11:50
 * @Author: lhh
 * @Description: 第三十二页
 */
public class TemplateMethod {
    public final void print(String message){
        System.out.println("#######");
        warpPrint(message);
        System.out.println("#######");

    }
    protected void warpPrint(String message){

    }

    public static void main(String[] args) {
        TemplateMethod t1 = new TemplateMethod(){
            @Override
            protected void warpPrint(String message){
                System.out.println("*"+message+"*");
            }
        };
        t1.print("Hello Thread");

        TemplateMethod t2 = new TemplateMethod(){
          @Override
          protected  void warpPrint(String message){
              System.out.println("+"+message+"+");
          }
        };

        t2.print("Hello Thread");

    }
}
