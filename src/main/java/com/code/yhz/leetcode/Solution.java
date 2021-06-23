package com.code.yhz.leetcode;

import java.io.*;
import java.util.*;

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
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     * 计算 1- n中出现 1的次数
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while(high != 0 || cur != 0) {
            if(cur == 0) res += high * digit;
            else if(cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }



    public static void readFileContent() throws IOException {
        File file = new File("D://test/aa.txt");
        BufferedReader reader = null;
        File writeFile = new File("D://test/bb.txt");
        if (!writeFile.exists()){
            writeFile.createNewFile();
        }
        BufferedWriter writer = null;
        List<String> monthList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        Map<String,Map<String,String>> nameCountMap = new HashMap<>();
        try {
            writer = new BufferedWriter(new FileWriter(writeFile));
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                String[] s = tempStr.split(" ");
                String name = s[0];
                String month = s[1];
                String value = s[2];
                if (!nameList.contains(name)){
                    nameList.add(name);
                }
                if (!monthList.contains(month)){
                    monthList.add(month);
                }

                if (nameCountMap.containsKey(name)){
                    Map<String, String> data = nameCountMap.get(name);
                    data.put(month,value);
                    nameCountMap.put(name,data);
                }else {
                    Map<String, String> data = new HashMap<>();
                    data.put(month,value);
                    nameCountMap.put(name,data);
                }
            }
            String header = "姓名 ";

            for (String month:monthList) {
                header +="\t"+month;
            }
            header+="\n";
            for (String name:nameList){
                header+=name;
                Map<String, String> dataMap = nameCountMap.get(name);
                for (String month:monthList){
                    String value = "空值";
                    if (dataMap.get(month) != null){
                        value = dataMap.get(month);
                    }
                    header+=("\t"+value);
                }
                header+="\n";

            }
            writer.write(header);
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

    }
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static int longestStr(String s){
        int rk = -1,ans=0;
        for (int i=0;i<s.length() && rk <s.length();){
            Map<Character,Integer> map = new HashMap<>();
            map.put(s.charAt(i),i);
            int tmp = ans;
            for (rk = i+1;rk <s.length();rk ++){
                if (map.containsKey(s.charAt(rk))){
                    tmp = rk -i;
                    i = map.get(s.charAt(rk))+1;
                    break;
                }else {
                    map.put(s.charAt(rk ),rk);
                }
            }
            ans = Math.max(ans,tmp);
            System.out.println(ans);
        }
        return ans;
    }
    public static void main(String[] args) {
       String s = "abbdefabc";
        int i = longestStr(s);
        System.out.println(i);

    }
}
