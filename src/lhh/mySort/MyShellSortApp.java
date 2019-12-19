package lhh.mySort;

import java.util.Arrays;

/**
 * @program: IdeaJava
 * @Date: 2019/12/13 10:50
 * @Author: lhh
 * @Description: 希尔排序
 */
public class MyShellSortApp
{
    private static void shellSort(int[] arr)
    {
        int length = arr.length;
        for(int gap = length/2;gap > 0;gap /=2)
        {
            for(int i = gap;i < length; i++)
            {
                insertI(arr,gap,i);
            }
        }
    }

    private static void insertI(int[] arr,int gap,int i)
    {
        int inserted = arr[i];
        int j;
        for (j = i-gap;j >= 0 && inserted < arr[j];j -= gap)
        {
            arr[j+gap] = arr[j];
        }
        arr[j+gap] = inserted;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,6,3,1,5,4,1,7};
        shellSort(a);
        System.out.println(Arrays.toString(a));
    }
}
