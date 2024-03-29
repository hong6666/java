package lhh.mySort;

import java.util.Arrays;

/**
 * @program: IdeaJava
 * @Date: 2020/2/29 9:51
 * @Author: lhh
 * @Description: 冒泡排序
 */
public class BubbleSortApp {
    public static int[] bubbleSort(int[]nums)
    {
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=0;j<nums.length-1-i;j++)
            {
                if(nums[j]>nums[j+1])
                {
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }

            }
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    public static int[] bubbleSort2(int[] a)
    {
        boolean bool = true;
        while(bool)
        {
            // 当下面代码没执行就说明，排序都排好了，就不用再循环了
            bool=false;
            for(int i = 0;i<a.length-1;i++)
            {
                if(a[i]>a[i+1])
                {
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1]=temp;
                    bool=true;
                }
            }
            System.out.println(Arrays.toString(a));
        }
        return a;
    }

    public static void main(String[] args) {
        int nums[] = {8,2,3,5};
        BubbleSortApp.bubbleSort(nums);

    }
}
