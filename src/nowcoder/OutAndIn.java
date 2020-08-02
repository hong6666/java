package nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * OutAndIn  输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据包括多组。
 *
 * @author 李弘昊
 * @since 2020/7/30
 */
public class OutAndIn {

/*    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null )
        {
            String[] num = str.split(" ");
            int a = Integer.parseInt(num[0]);
            int b = Integer.parseInt(num[1]);
            System.out.println(a+b);
        }
    }*/
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            String in = s.nextLine();
            String[] arr = in.split(" ");
            int s1=0;
            for(int i = 0;i<arr.length;i++){
                s1=s1+Integer.valueOf(arr[i]);

            }
            System.out.println(s1);
        }
    }

}
