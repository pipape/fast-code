package com.xiaoft.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @ClassName ListNodeSolution
 * @Description
 * @Author xiaofeiteng
 * @Date 2021/8/15 3:58 下午
 * @Version V1.0
 */
public class ListNodeSolution {
    public static int [] reversePrint(ListNode head){
        if(head == null){
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode pNode = head;
        while (pNode != null){
            stack.push(pNode.val);
            pNode = pNode.next;
        }
        int[] retArr = new int[stack.size()];
        int count = 0;
        while (!stack.isEmpty()){
            retArr[count ++] = stack.pop();
        }

        return retArr;
    }

    /*
     * @Description 头插法构建链表，会倒序
     * @Param
     * @Return: com.xiaoft.ListNode.ListNode
     * @Author: xiaofeiteng
     * @Date: 2021/8/14 6:50 下午
     */
    public static ListNode getNodeList(){
        ListNode head = null;
        int[] nums = new int[]{1,2,3,4};
        for(int i = 0; i < nums.length; i++){
            ListNode node = new ListNode(nums[i]);
            node.next = head;
            head = node;
        }
        return head;
    }

    public static ListNode getNodeListHead(){
        int[] arr = new int[]{1,2,3,4};
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for(int i = 0; i < arr.length; i++){
            ListNode node = new ListNode(arr[i]);
            dummy.next = node;
            dummy = node;
        }

        return head.next;

    }

    /*
     * @Description 递归的本质也是栈
     * @Author: xiaofeiteng
     * @Date: 2021/8/14 6:46 下午
     */
    public static void reversePrint2(ListNode head){
        if(head == null){
            return;
        }
        reversePrint2(head.next);
        System.out.println(head.val);
    }

    public static void main(String[] args){
        //reversePrint(getNodeList());
        reversePrint(getNodeListHead());
        //reversePrint2(getNodeList());
    }

}
