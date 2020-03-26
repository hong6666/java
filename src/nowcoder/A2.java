package nowcoder;

/**
 * @program: IdeaJava
 * @Date: 2020/3/25 20:21
 * @Author: lhh
 * @Description: 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class A2 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("we are family");
        A2 a2 = new A2();
        System.out.println("replaceSpace: "+a2.replaceSpace(sb));
        System.out.println("replaceSpace2: "+a2.replaceSpace2(sb));


    }
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }
    public String replaceSpace2(StringBuffer str) {
        StringBuffer br = new StringBuffer();
        for (int i = 0;i < str.length();i++)
        {
            char c = str.charAt(i);
            if (c == ' '){
                br.append("%20");
            }else {
                br.append(c);
            }
        }
        return br.toString();
    }
}
