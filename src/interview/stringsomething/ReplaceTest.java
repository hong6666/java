package interview.stringsomething;

/**
 * ReplaceTest
 * replace并不是替换一个，是替换所有匹配到的字符或字符串
 * replaceAll可以解析字符使用正则表达式
 * @author 李弘昊
 * @since 2020/6/3
 */
public class ReplaceTest {

    public static void main(String[] args) {
        String str = "hello world !!";
        System.out.printf("替换之前：{%s}\n",str);

        str = str.replace('l','d');
        System.out.printf("替换所有字符：{%s}\n",str);

        str = str.replace("d","l");
        System.out.printf("替换所有字符：{%s}\n",str);

        str = str.replaceAll("l","d");
        System.out.printf("替换所有字符：{%s}\n",str);

        str = str.replaceFirst("d","");
        System.out.printf("替换第一个d：{%s}\n",str);


    }
}
