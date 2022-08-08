package com.cxy.advanced.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Copyright (c) 2021, 北京卡拉卡尔科技股份有限公司
 * All rights reserved.
 *
 * @author xinyi.chen@karakal.com.cn
 * @date 2022/08/08
 * @description 两数之和
 * @since JDK1.8
 */
public class TwoNumberSum {
    public static void main(String[] args) {
        //Integer[] integers = {1, 2, 3, 4, 5, 6, 7};
        Integer[] integers = {3, 2, 3};

        System.out.println(Arrays.toString(solution1(integers, 6)));
        System.out.println(Arrays.toString(solution2(integers, 6)));
    }

    /**
     * 解法1
     * 直接双层遍历！ 复杂度O(n*n)
     * @return
     */
    public static int[] solution1(Integer[] nums, Integer target){
        int length = nums.length;
        for(int i = 0; i< length; i++){
            for (int j = i+1; j< length; j++){
                if (nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    /**
     * 解法2
     * 遍历数组 字典里不存在就加入 存在就返回
     * @return
     */
    public static int[] solution2(Integer[] nums, Integer target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if (map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}