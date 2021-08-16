package com.xiaoft.algorithm;

/*
 * @ClassName AlgorithmSolution
 * @Description 算法
 * @Author xiaofeiteng
 * @Date 2021/8/15 5:09 下午
 * @Version V1.0
 */
public class AlgorithmSolution {
    static int[] arr;
    public static int fibonacci(int n){
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else if(arr[n] != 0){
            return arr[n];
        }else{
            arr[n] = (fibonacci(n-1) + fibonacci(n-2))%(1000000007);
            return arr[n];
        }

    }

    public static void main(String[] args) {
        int count =95;
        arr = new int[count+1];
        System.out.println(fibonacci(count));
    }
}
