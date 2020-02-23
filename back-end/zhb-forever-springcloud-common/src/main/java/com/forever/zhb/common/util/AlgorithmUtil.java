package com.forever.zhb.common.util;

import java.util.stream.IntStream;

public class AlgorithmUtil {

    private static int[] nums = {1,6,3,8,2,0,6,4,3,8,9,23,5,11};
    
    public static void main(String[] args) {
        int index = IntStream.range(0, nums.length).reduce((i,j)->nums[i]>nums[j]?i:j).getAsInt();
        PrintUtil.print(nums[index]);
    }

}
