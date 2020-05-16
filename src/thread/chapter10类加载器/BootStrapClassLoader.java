package thread.chapter10类加载器;

/**
 * BootStrapClassLoader
 * 根加载器又称为Bootstrap类加载器，该类加载器是最为顶层的加载器负责核心类库的加载，
 * 比如java.lang包都是有它加载的，可以通过 -Xbootclasspath来指定根加载器的路径
 * @author 李弘昊
 * @since 2020/5/14
 */
public class BootStrapClassLoader {

    public static void main(String[] args)
    {
        System.out.println("Bootstrap: " + String.class.getClassLoader());
        System.out.println("**" + System.out);
        System.out.println("---" + System.getProperty("java.class.path"));
        //sun.boot.class.path为空，不知道啥原因
        System.out.println(System.getProperty("sun.boot.class.path"));
    }

}
