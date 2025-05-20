package org.roman.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
//        System.out.println(removeElement.removeElement(new int[]{3,2,2,3}, 3));
        System.out.println(removeElement.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }

    public int removeElement(int[] nums, int val) {
        List<Integer> number = new ArrayList<>();
        int loop = 0;
        int index = 0;

        while(loop < nums.length){
            if(nums[loop] != val){
                nums[index] = nums[loop];
                number.add(nums[loop]);
                index++;
            }
            loop++;
        }
        nums = Arrays.copyOf(nums, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        System.out.println(number);
        return number.size();
    }
}
