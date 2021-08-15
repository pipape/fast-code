package com.xiaoft;

public class Array {
    public static int getFirstDuplicateNum(int[] n){
        if(n == null || n.length < 1){
            return -1;
        }

        for(int i = 0; i < n.length; i++){
            if(n[i] < 0 || n[i] > n.length-1){
                return -1;
            }
        }

        for(int i = 0; i< n.length; i++){
            while(i != n[i]){
                if (n[i] == n[n[i]]){
                    return n[i];
                }

                int temp = n[i];
                n[i] = n[n[i]];
                n[temp] = temp;   //注意此处不能用n[n[i]],因为n[i]值已经变化
            }
        }

        return -1;
    }


    /*
     * @Description 在范围内的计数
     * @Author: xiaofeiteng
     * @Date: 2021/8/14 3:36 下午
     */
    public static int countRangeNum(int[] nums, int start, int end){
        int count = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= end && nums[i] >= start){
                count ++;
            }
        }
        return count;
    }

    public static int getDuplicateNum(int[] nums){
        if(nums == null || nums.length < 0){
            return -1;
        }

        for(int i = 1; i < nums.length; i++){
            if(nums[i] >= nums.length){
                return -2;
            }
        }

        int start = 1, end = nums.length - 1;
        while(start <= end){
            int middle = ((end - start) >> 1) + start;
            int count = countRangeNum(nums,start,middle);
            if(start == end){
                if(count > 1){
                    return start;
                }else {
                    return -1;
                }
            }

            if(count > (middle - start + 1)){
                end = middle;
            }else {
                start = middle + 1;
            }
        }

        return -1;
    }

    public static boolean findNumsIn2DArray(int[][] nums,int target){
        if(nums == null || nums.length < 0){
            return false;
        }
        int col = 0;
        int row = nums.length-1;
        while (col < nums[0].length && row >= 0){
            //注意用一个带分支的判断条件，否则可能出现越界
            if(target == nums[row][col]){
                return true;
            }else if(target > nums[row][col]){
                col ++;
            }else if(target < nums[row][col]){
                row --;
            }
        }
        return false;
    }

    public static String replaceAllSpace(char[] arr){
        int spaceCount = 0;
        int length = arr.length;
        for(int i = 0; i < length; i++){
            if(' ' == arr[i]){
                spaceCount ++;
            }
        }
        int newLength = length + spaceCount * 2 -1;
        char[] newArr = new char[newLength+1];
        for(int i = length-1; i >= 0; i--){
            if(' ' == arr[i]){
                newArr[newLength--] = '0';
                newArr[newLength--] = '2';
                newArr[newLength--] = '%';
            }else {
                newArr[newLength--] = arr[i];
            }
        }

        return String.copyValueOf(newArr);
    }

    public static void main(String[] arg){
        int[] nums = {0,3,2,4,6,1,2,5};
        int[][] nums2 = {{1,2,3},{4,5,6},{7,8,9}};
        //System.out.println(getFirstDuplicateNum(nums));
        //System.out.println(getDuplicateNum(nums));
        //System.out.println(findNumsIn2DArray(nums2,1));
        String str = "we are happy";
        char[] charArr = str.toCharArray();
        System.out.println(replaceAllSpace(charArr));
    }
}
