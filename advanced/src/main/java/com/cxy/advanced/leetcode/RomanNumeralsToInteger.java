package com.cxy.advanced.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xinyi.chen
 * @date 2022/9/28 0028
 * @description 罗马数转数字
 * @since JDK1.8
 */
public class RomanNumeralsToInteger {
    public static void main(String[] args) {
        System.out.println(solution1("LVIII"));
        System.out.println(solution1("IV"));
    }

    /**
     * 将字符串转化为字符，将当前字符代表的值与下一位作比较，若大于等于则相加，否则减去当前数值
     * @param s
     * @return
     */
    private static int solution1(String s){
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            Integer current = map.get( chars[i]);
            Integer next = 0;
            if (i!=chars.length-1){
                next = map.get(chars[i+1]);
            }
            if (current>=next){
                result += current;
            }else {
                result -= current;
            }
        }
        return result;
    }
}
