package com.xiaoft.codeview817;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {
    public int[] inputNums(){
        Scanner input =new Scanner(System.in);
        String s=input.nextLine();
        String[] split = s.split(" ");
        int[] nums=new int[split.length];
        for(int i=0;i<split.length;i++){
            Integer ss = new Integer(split[i]);
            if(ss >= -65536 && ss <= 65535){
                nums[i] = ss;
            }
        }

        input.close();

        return nums;
    }
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        Main main = new Main();
        int[] arr = main.inputNums();
        if(arr == null || arr.length < 1){
            return;
        }

        int max = main.lengthOfLIS(arr);

        for(int i = 0; i < arr.length - max; i++){
            boolean isStart = true;
            for(int j = 1; j < max; j ++){
                if (arr[j+i] < arr[j+i-1]){
                    isStart = false;
                    break;
                }
            }
            if(isStart){
                System.out.println(i);
                break;
            }
        }
    }
}
