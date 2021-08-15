package com.xiaoft.QueueAndStack;

import java.util.Stack;

/*
 * @ClassName CQueue
 * @Description 两个栈实现一个队列
 * @Author xiaofeiteng
 * @Date 2021/8/15 3:57 下午
 * @Version V1.0
 */
public class CQueue {
    static Stack<Integer> s1;
    static Stack<Integer> s2;

    public CQueue(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public static void addTail(Integer num){
        s1.push(num);
    }

    public static Integer deleteHead(){
        if(s1.isEmpty() && s2.isEmpty()){
            return -1;
        }else if(!s2.isEmpty()){
            return s2.pop();
        }else {
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }

    public static void main(String[] args) {

    }


}
