package com.xiaoft.algorithm;

import java.util.Random;

public class SearchAndSort {
    //快排递归
    public static void quickSort(int[] nums,int start,int end){
        //start == end
        if(start == end){
            return;
        }
        //获取第一个index，开始划分
        int index = partition(nums,start,end);
        if(index > start){
            quickSort(nums,start,index -1);
        }
        if(index < end){
            quickSort(nums,index+1,end);
        }

    }

    static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //快排划分
    public static int partition(int[] nums,int start,int end){
        Random random = new Random();
        int i = Math.abs(random.nextInt())%(end - start) + start;
        swap(nums,i,end);
        int small = start - 1;
        for(i = start; i < end; i++){
            if(nums[i] < nums[end]){
                ++ small;
                swap(nums,small,i);
            }
        }
        ++ small;
        swap(nums,small,end);

        return small;
    }


    //计数排序
    public static void collectionSort(int[] nums){
        int[] count = new int[100];
        for(int i=0; i<nums.length; i++){
            count[nums[i]] ++;
        }
        int index = 0;
        for(int i = 0; i < 100; i ++){
            while (count[i] > 0){
                nums[index ++] = i;
                count[i] --;
            }
        }
    }

    public static int getMin(int[] nums){
        if(nums == null){
            return 0;
        }
        return 0;
    }

    public static int minInOrder(int[] nums){
        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(min > nums[i]){
                min = nums[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,1,1};
        //quickSort(nums,0,nums.length-1);
        //collectionSort(nums);
        System.out.println(getMin(nums));;
//        for (int i=0; i<nums.length; i++){
//            System.out.println(nums[i]);
//        }
    }
}
