package lhh.iotest;

import java.io.*;

/**
 * @program: IdeaJava
 * @Date: 2019/11/29 10:36
 * @Author: lhh
 * @Description:
 */
public class FileStreamTest2 {
    public static void main(String[] args) throws IOException {
        File f = new File("a.txt");
        FileOutputStream fop = new FileOutputStream(f);
        //构建FileOutputStream对象，参数可以指定编码，默认为操作系统默认编码window是gbk
        OutputStreamWriter writer = new OutputStreamWriter(fop,"UTF-8");
        writer.append("中文输入");
        writer.append("\r\n");
        writer.append("English");
        writer.close();
        fop.close();
        FileInputStream fip = new FileInputStream(f);
        InputStreamReader reader = new InputStreamReader(fip,"UTF-8");

        StringBuffer sb = new StringBuffer();
        while(reader.ready()){
            sb.append((char)reader.read());
        }
        System.out.println(sb.toString());
        reader.close();
    }
}
