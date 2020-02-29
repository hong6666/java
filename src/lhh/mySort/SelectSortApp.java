package lhh.mySort;

import java.util.Arrays;

/**
 * @program: IdeaJava
 * @Date: 2020/2/29 10:37
 * @Author: lhh
 * @Description: 选择排序
 */
public class SelectSortApp {

    public static int[] selectSort(int[] a)
    {
        for(int i = 0;i < a.length-1;i++)
        {
            int  min = i;
            for(int j = i + 1;j < a.length;j++)
            {
                if(a[j] < a[min])
                {
                    min = j;
                }
            }
            if(min != i)
            {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int a[] = {5,3,4,1,8,6,4};
        System.out.println(Arrays.toString(selectSort(a)));
    }
}


















