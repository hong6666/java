package lhh.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: IdeaJava
 * @Date: 2019/11/25 23:42
 * @Author: lhh
 * @Description: 全排列，给定一个没有重复数字的序列，返回其所有可能的全排列
 */
public class FullArraySolution {

    public static List<List<Integer>> permute(int[] nums)
    {

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track,res);
        return res;
    }

    public static void backtrack(int[] nums,LinkedList<Integer> track,List<List<Integer>> res)
    {
        if(track.size() == nums.length)
        {
            res.add(new LinkedList(track));
            return;
        }
        for(int i = 0;i < nums.length;i++)
        {
            if(track.contains(nums[i]))continue;
            track.add(nums[i]);
            backtrack(nums,track,res);
            track.removeLast();
        }

    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        List<List<Integer>> res = permute(a);

        for (int i = 0;i < res.size();i++){
            List<Integer> list = res.get(i);
            for(int j = 0;j < list.size();j++){
                System.out.print(list.get(j));
            }
            System.out.println();
        }
    }


}













