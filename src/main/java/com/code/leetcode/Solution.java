package com.code.leetcode;

//leetcode
public class Solution {

    /**
     * 给你一个整数数组 nums ，
     * 除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。
     * 请你找出并返回那个只出现了一次的元素。
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num: nums) {
                total += ((num >> i) & 1);
                System.out.print(num+":"+total +";");
            }
            System.out.println();
            System.out.println(i+":total:"+total);
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
            System.out.println("ans:"+ans);
        }
        return ans;
    }

    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     */
    //双指针解决
    public int removeDuplicates(int[] A) {
        //边界条件判断
        if (A == null || A.length == 0)
            return 0;
        int left = 0;
        for (int right = 1; right < A.length; right++)
            //如果左指针和右指针指向的值一样，说明有重复的，
            //这个时候，左指针不动，右指针继续往右移。如果他俩
            //指向的值不一样就把右指针指向的值往前挪
            if (A[left] != A[right])
                A[++left] = A[right];
        return ++left;
    }

    public static void main(String[] args) {
        int[] num = {1,1,1,2};
        int i = singleNumber(num);
        System.out.println(i);
    }

}
