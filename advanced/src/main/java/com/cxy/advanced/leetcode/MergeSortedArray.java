package com.cxy.advanced.leetcode;

import java.util.Arrays;

/**
 * @author xinyi.chen
 * @date 2022/9/29 0029
 * @description 合并两个有序数组 使合并后的数组同样按 非递减顺序 排列
 *  给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * @since JDK1.8
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] array1 = {0, 0, 0, 0, 0, 0};
        int[] array2 = {1, 2, 5, 4, 3};
        solution2(array1,0, array2,5);
        System.out.println(Arrays.toString(array1));
    }

    private static void solution(int[] nums1, int m, int[] nums2, int n){
        boolean flag = m==0;
        for (int i = 0; i < nums2.length; i++) {
            if (flag){
                nums1[i] = nums2[i];
            }else {
                nums1[m+i] = nums2[i];
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i+1; j < nums1.length; j++) {
                if (nums1[j]<nums1[i]) {
                    int tem = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = tem;
                }
            }
        }
    }

    private static void solution2(int[] nums1, int m, int[] nums2, int n){
        int i = nums1.length;
        while (n>0){
            if (m>0 && nums1[m-1] > nums2[n-1]){
                nums1[--i]=nums1[--m];
            }else {
                nums1[--i]=nums2[--n];
            }
        }
    }
}
