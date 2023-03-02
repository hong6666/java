package lhh.mySort;

import java.util.Arrays;

/**
 * @program: IdeaJava
 * @Date: 2019/12/18 11:49
 * @Author: lhh
 * @Description: 快速排序
 */
public class QuickSortAppF {
    public static void quick_sort(int arr[], int left, int right) {
        if (left < right) {
            int index = partition(arr, left, right);
            quick_sort(arr, 0, index-1);
            quick_sort(arr, index+1, right);
        }
    }


    public static int partition2(int arr[], int left, int right) {
        int pivot = arr[left];
        int index = left + 1;
        for (int i = index; i < right; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, index);
                index ++;
            }
        }
        swap(arr, left, index -1);
        return index - 1;
    }

    public static int partition(int arr[], int left, int right) {
        int pivot = arr[right];
        int index = left;
        for (int i = index; i < right; i++) {
            if (arr[i] < pivot) {
                swap(arr,i,index);
                index ++;
            }
        }
        swap(arr, index, right);
        return index - 1;
    }

    public static void swap(int arr[],int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6,3,2,9,7,1,50,30,55,24,8};
        quick_sort(arr,0,6);
        System.out.println(Arrays.toString(arr));
    }
}
