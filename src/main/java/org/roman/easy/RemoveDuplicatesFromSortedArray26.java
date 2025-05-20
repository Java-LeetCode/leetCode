package org.roman.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RemoveDuplicatesFromSortedArray26 {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray26 r = new RemoveDuplicatesFromSortedArray26();
//        System.out.println(r.removeDuplicates(new int[]{1,1,2,2,3,4,5,6,6,7,7,7,8,1,2,5}));
//        System.out.println(r.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println(r.removeDuplicates(new int[]{0, 0, 1, 1}));

    }

    public int removeDuplicates(int[] nums) {
        List<Integer> numbers = new ArrayList<>();
        int loop = 0;
        int index = 0;

        while(loop < nums.length){
            if(!numbers.contains(nums[loop])){
                numbers.add(nums[loop]);
                nums[index] = nums[loop];
                index++;
            }
            loop++;
        }
        nums = Arrays.copyOf(nums, nums.length - numbers.size());
        return numbers.size();
    }
}
