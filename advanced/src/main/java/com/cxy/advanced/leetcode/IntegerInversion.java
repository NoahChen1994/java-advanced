package com.cxy.advanced.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinyi.chen
 * @date 2022/9/28 0028
 * @description 整数反转
 * @since JDK1.8
 */
@Slf4j
public class IntegerInversion {
    public static void main(String[] args) {
        System.out.println(solution2(1000000001));
        System.out.println(solution2(12321));
    }

    /**
     * 取出每个末位的数值放入数组，遍历数组生成反转之后的数值，与原数值作比较
     * @param x
     * @return
     */
    private static boolean solution1(int x){
        if(x<0){
            return false;
        }
        if (x==0){
            return true;
        }
        int temp = x;
        List<Integer> list = new ArrayList<>();
        //从各位依次取出每一个数放入数组
        while(temp>0){
            list.add(temp%10);
            temp = temp / 10;
        }
        temp = 0;
        //遍历数组获取反转之后的数
        for (int i = 0; i<list.size(); i++) {
            //大于10亿再*10将会溢出
            if (temp<1_000_000_000){
                //最后一位直接相加
                if (i==list.size()-1){
                    temp = temp+list.get(i);
                }else {
                    temp = (temp+list.get(i))* 10;
                }
            }else{
                temp = temp+list.get(i);
            }
        }
        return temp == x;
    }

    /**
     * 取出首位与末位进行比较
     * @param x
     * @return
     */
    private static boolean solution2(int x){
        if (x<0){
            return false;
        }

        if (x==0){
            return true;
        }

        int temp = x;
        int num = 1;
        while(temp>=10){
            num *= 10;
            temp /= 10;
        }
        while(x>0){
            if (x/num != x%10){
                return false;
            }
            //去除首位与末位
            x = x%num/10;
            num /= 100;
        }
        return true;
    }
}
