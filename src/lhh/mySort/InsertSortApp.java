package lhh.mySort;

import java.util.Arrays;

/**
 * @program: IdeaJava
 * @Date: 2019/12/12 16:35
 * @Author: lhh
 * @Description: 插入排序
 */
public class InsertSortApp {
    public static int[] insertSort(int [] a){
        int length = a.length;
        if(a == null || length < 2)return a;
        else{
            for(int i = 0;i < length -1;i++){
                for(int j = i + 1;j > 0;j--){
                    if(a[j] < a[j-1]){
                        int temp = a[j];
                        a[j] = a[j-1];
                        a[j-1] = temp;
                    }
                    else break;
                }
            }
        }
        return a;
    }
    public static void main(String[] args) {
        int[] a = new int[]{2,4,1,5,7,1};
        System.out.println(Arrays.toString(insertSort(a)));
    }
}
