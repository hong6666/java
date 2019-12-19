package lhh.mySort;

import java.util.Arrays;

/**
 * @program: IdeaJava
 * @Date: 2019/12/18 11:49
 * @Author: lhh
 * @Description: 快速排序
 */
public class QuickSortApp {
    public static void quick_sort(int a[],int low, int hight)
    {
        if(low < hight)
        {
            int i = low, j = hight, x = a[low];
            while(i < j)
            {
                while(i < j && a[j] >= x) j--;
                if(i < j) a[i++] = a[j];

                while(i < j && a[i] < x) i++;
                if(i < j) a[j--] = a[i];
            }
            a[i] = x;
            quick_sort(a,low,i - 1);
            quick_sort(a,i + 1,hight);
        }
    }

    public static void main(String[] args) {
        int[] a = {6,3,2,9,7,8};
        quick_sort(a,0,5);
        System.out.println(Arrays.toString(a));
    }
}
