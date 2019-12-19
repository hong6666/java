package lhh.fanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @program: IdeaJava
 * @Date: 2019/11/30 10:01
 * @Author: lhh
 * @Description:
 */
public class MyConstructors {
    public static void main(String[] args) throws Exception{
        //1.加载Class对象
        Class clazz = Class.forName("lhh.fanshe.Student");

        System.out.println("***********所有公有构造方法***********");
        Constructor[] conArray = clazz.getConstructors();
        for(Constructor c : conArray){
            System.out.println(c);
        }

        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)************");
        conArray = clazz.getDeclaredConstructors();
        for(Constructor c : conArray){
            System.out.println(c);
        }

        System.out.println("***********获取公有、无参的构造方法**********");
        Constructor con = clazz.getConstructor(null);

        System.out.println("con = " + con);
        Object obj = con.newInstance();

        System.out.println("***********获取私有构造方法，并调用********");
        con = clazz.getDeclaredConstructor(char.class);

        System.out.println(con);
        con.setAccessible(true);
        obj = con.newInstance('南');

        System.out.println("***************获取所有的”公有“方法*******************");

        Method[] methodArray = clazz.getMethods();
        for(Method m : methodArray){
            System.out.println(m);
        }

    }
}
