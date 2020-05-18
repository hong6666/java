package thread.chapter10类加载器;

/**
 * ExtClassLoader
 *
 * @author 李弘昊
 * @since 2020/5/17
 */
public class ExtClassLoader {

    public static void main(String[] args) throws ClassNotFoundException{
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.version"));

        System.out.println(System.getProperty("java.class.path"));

    }

}
