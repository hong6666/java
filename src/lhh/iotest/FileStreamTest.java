package lhh.iotest;

import java.io.*;

/**
 * @program: IdeaJava
 * @Date: 2019/11/29 10:21
 * @Author: lhh
 * @Description:
 */
public class FileStreamTest {
    public static void main(String[] args) {
        try{
            byte bw[] = {11,22,3,40,5};
            OutputStream os = new FileOutputStream("test.txt");
            for (int x = 0; x < bw.length; x++)
            {
                os.write(bw[x]);
            }
            os.close();

            InputStream is = new FileInputStream("test.txt");
            int size = is .available();

            for(int i = 0;i < size; i++)
            {
                System.out.print((char)is.read() + "  ");
            }
            is.close();


        }catch(IOException e){
            System.out.print("Exception");
        }
    }

}
