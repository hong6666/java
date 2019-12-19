package lhh.dataStructureAndAlgorithm;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @program: IdeaJava
 * @Date: 2019/11/29 11:30
 * @Author: lhh
 * @Description:
 */
public class EnumerationTester {
    public static void main(String args[]){
        Enumeration<String> days;

        Vector<String> dayNames = new Vector<>();
        dayNames.add("Sunday");
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        dayNames.add("Wednesday");
        dayNames.add("Friday");
        dayNames.add("Saturday");

        days = dayNames.elements();
        while(days.hasMoreElements()){
            System.out.println(days.nextElement());
        }


    }
}
