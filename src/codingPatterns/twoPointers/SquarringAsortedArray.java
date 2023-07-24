package codingPatterns.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Statement
Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.
Example 1:
Input: [-2, -1, 0, 2, 3]
Output: [0, 1, 4, 4, 9]
Example 2:
Input: [-3, -1, 0, 1, 2]
Output: [0 1 1 4 9]
 */
public class SquarringAsortedArray {
    public static void main(String[] args) {
        //int[] arr = {-2,-1,0,2,3};
        int[] arr = {-3, -1, 0, 1, 2};
        int[] ans = new int[arr.length];
        int l = 0;
        int r = arr.length-1;
        int cnt = arr.length-1;
        while(l < r){
            if(arr[l]*arr[l] >= arr[r]*arr[r]){
                ans[cnt] = arr[l]*arr[l];
                l++;
            } else {
                ans[cnt] = arr[r]*arr[r];
                r--;
            }
            cnt--;
        }
        ans[cnt] = arr[l]*arr[l];

        System.out.println(Arrays.toString(ans));
    }
}
