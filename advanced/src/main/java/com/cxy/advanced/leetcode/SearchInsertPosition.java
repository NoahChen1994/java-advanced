package com.cxy.advanced.leetcode;

/**
 * @author xinyi.chen
 * @date 2022/9/29 0029
 * @description 搜索插入位置
 *  给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * @since JDK1.8
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(solution1(new int[]{1, 2, 3, 5}, 6));
        System.out.println(solution2(new int[]{1, 3, 5, 6}, 5));
    }

    /**
     * 双指针
     * @param nums
     * @param target
     * @return
     */
    private static int solution1(int[] nums, int target){
        int result = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target){
                result =  i;
                break;
            }

        }
        if (result==-1){
            result = nums.length;
        }
        return result;
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    private static int solution2(int[] nums, int target){
        int length = nums.length;
        int left = 0;
        int right = length-1;
        while (left<=right){
            int mid = (left + right) / 2;
            if (nums[mid]<target){
                left = mid +1;
            }else {
                right = mid -1;
            }
        }
        return left;
    }
}
