package com.cxy.advanced.leetcode;

import java.util.Arrays;

/**
 * @author xinyi.chen
 * @date 2022/9/29 0029
 * @description 加一 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * @since JDK1.8
 */
public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution1(new int[]{1, 2, 3, 4, 5, 9})));
        System.out.println(Arrays.toString(solution1(new int[]{9})));
    }

    /**
     * 找到不为9的元素，将其+1，将其之后的元素设置为0
     * @param digits
     * @return
     */
    private static int[] solution1(int[] digits){
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] != 9){

                digits[i]++;
                for (int j = i+1; j < length; j++) {
                    digits[j] = 0;
                }
                return digits;
            }
        }
        //全为9的情况
        int[] result = new int[length+1];
        result[0] = 1;
        return result;
    }
}
