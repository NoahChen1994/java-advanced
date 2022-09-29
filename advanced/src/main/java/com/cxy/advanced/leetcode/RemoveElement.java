package com.cxy.advanced.leetcode;

/**
 * @author xinyi.chen
 * @date 2022/9/29 0029
 * @description 移除元素
 * @since JDK1.8
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] array = {1, 4, 3, 2, 4};
        int newLength = solution1(array, 4);
        for (int i = 0; i < newLength; i++) {
            System.out.println(array[i]);
        }
    }

    private static int solution1(int[] nums,int val){
        if (nums.length==0){
            return 0;
        }
        int slow = 0;
        int fast = 0;
        while (fast<nums.length){
            if (nums[fast]!=val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
