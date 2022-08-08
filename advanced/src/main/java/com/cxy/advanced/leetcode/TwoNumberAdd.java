package com.cxy.advanced.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Copyright (c) 2021, 北京卡拉卡尔科技股份有限公司
 * All rights reserved.
 *
 * @author xinyi.chen@karakal.com.cn
 * @date 2022/08/08
 * @description 两数相加
 * @since JDK1.8
 */
public class TwoNumberAdd {
    public static void main(String[] args) {
        ListNode l1 = init(new Integer[]{9, 9, 9,9,9,9,9});
        ListNode l2 = init(new Integer[]{9, 9, 9});
        print(solution1(l1,l2));

    }

    /**
     * 解法
     * @return
     */
    public static ListNode solution1(ListNode l1, ListNode l2){
        //用于标识头部的指针
        ListNode pre = new ListNode(0);
        //用于记录每个节点值的指针
        ListNode cur = pre;
        //进位标记
        int carry = 0;

        //当两个链表都置于尾部时跳出
        while(l1!=null || l2!=null){
            //节点如果为null则补零
            int x=l1==null?0:l1.val;
            int y=l2==null?0:l2.val;
            //计算两数之和 需要带上进位标记值
            int sum = x + y +carry;
            //获取进位标记
            carry = sum / 10;
            //获取和值
            sum = sum % 10;
            //将值写入下个节点 （因为是从0开始）
            cur.next = new ListNode(sum);
            //移动记录指针
            cur = cur.next;
            //移动递归指针
            if (l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        //当两个链表都走到结尾还存在进位标记时则需将进位值写入下一位
        if (carry == 1){
            cur.next = new ListNode(carry);
        }
        //返回记录链表
        return pre.next;
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){};

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode init(Integer[] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode tem = head;
        for (int i = 0; i < nums.length; i++) {
            tem.next = new ListNode(nums[i]);
            tem = tem.next;
        }
        return head.next;
    }

    public static void print(ListNode listNode){
        StringBuffer sb = new StringBuffer();
        sb.append(listNode.val).append(",");
        while (listNode.next!=null){
            listNode = listNode.next;
            sb.append(listNode.val).append(",");
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}