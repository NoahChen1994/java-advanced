package com.cxy.advanced.leetcode;

/**
 * @author xinyi.chen
 * @date 2022/9/28 0028
 * @description 从有序数组中删除重复元素
 * @since JDK1.8
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] array = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int size = solution1(array);
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 使用快慢指针 快指针作为遍历游标，通过与上一位比较，若不等，则将慢指针元素替换为当前元素，慢指针自增1
     * @param nums
     * @return
     */
    private static int solution1(int[] nums){
       if (nums.length==0){
           return 0;
       }
       int slow = 1;
       int fast = 1;
       while(fast<nums.length){
           if (nums[fast-1]!=nums[fast]){
               nums[slow] = nums[fast];
               slow++;
           }
           fast++;
       }
       return slow;
    }
}
