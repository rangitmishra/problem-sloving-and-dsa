package codingPatterns.twoPointers;

import java.util.Arrays;

/*
Problem Statement
Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space;
after removing the duplicates in-place return the new length of the array.
Example 1:
Input: [2, 3, 3, 3, 6, 9, 9]
Output: 4
Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
Example 2:
Input: [2, 2, 2, 11]
Output: 2
Explanation: The first two elements after removing the duplicates will be [2, 11].
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 11};
        int left = 0;

        for(int i=1;i<arr.length;i++){
            if(arr[left] != arr[i]){
                left++;
                arr[left] = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(left+1);
    }
}
