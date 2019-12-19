package lhh.dataStructureAndAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: IdeaJava
 * @Date: 2019/11/17 16:44
 * @Author: lhh
 * @Description: 第N项是由第N-1项加n得到的，
 */
public class TrangleApp {

    static int theNumber;

    public static String getString()throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static int getInt() throws IOException{
        String s = getString();
        return Integer.parseInt(s);
    }


    public static int trangle(int n) {
        System.out.println("Entering: n= "+ n);
        if(n == 1) {
            System.out.println("returning 1");
            return 1;
        }
        else {
            int temp = n + trangle(n-1);
            System.out.println("Returning " + temp);
            return temp;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a number: ");
        theNumber = getInt();
        int theAnswer = trangle(theNumber);
        System.out.println("Triangle ="+theAnswer);
    }
}
