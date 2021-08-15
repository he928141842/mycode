package com.hh.myproject.base.面试题3.力扣第一题twoSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author hejiayuan
 * @create 2021-08-05-20:57
 */
public class TwoSumDemo {
    public static void main(String[] args) {
        /**
         *  给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
         *
         * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
         *

         */
        //输入：nums = [2,7,11,15], target = 9
        //输出：[0,1]
        //解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
        int [] nums = new int[]{2,7,11,15};

    }
    public static int [] sum(int [] nums ,int taget) {

        int n;
        HashMap<Integer,Integer> container = new HashMap();
        for (int i = 0; i < nums.length; i++) {

            if (container.containsKey(n = (taget-nums[i]))){
                return new int[]{container.get(n),i};
            }
            container.put(nums[i],i);
        }

        return new int[0];
    }
    
}
