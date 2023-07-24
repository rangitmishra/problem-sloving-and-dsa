package codingPatterns.twoPointers;

import java.util.Arrays;

/*
Triplet Sum Close to Target (medium)
Problem Statement
Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target number as possible,
return the sum of the triplet.
If there are more than one such triplet, return the sum of the triplet with the smallest sum.
Example 1:
Input: [-2, 0, 1, 2], target=2
Output: 1
Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
Example 2:
Input: [-3, -1, 1, 2], target=1
Output: 0
Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
Example 3:
Input: [1, 0, 1, 1], target=100
Output: 3
Explanation: The triplet [1, 1, 1] has the closest sum to the target.
 */
public class TripletSumClosestToTarget {

    public static void main(String[] args) {
        int target = 1;
        int[] arr = {-3, -1, 1, 2};
        Arrays.sort(arr);
        int closest = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;

        for(int i=0;i<arr.length-2;i++){
            int l = i+1;
            int r = arr.length-1;

            while(l < r){
                int sum = arr[i] + arr[l] + arr[r];
                if(Math.abs(sum-target) < closest){
                    closest = Math.min(closest, Math.abs(sum-target));
                    minSum = sum;
                }
                if(Math.abs(sum-target) == closest) {
                    minSum = Math.min(minSum, sum);
                }
                if(sum > target){
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    minSum = target;
                    break;
                }
            }
            if(minSum == target){
                break;
            }
        }

        System.out.println(minSum);

    }
}
