package codingPatterns.slidingWindow;

/*
Problem Statement #
Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
Example 1:
Input: [2, 1, 5, 1, 3, 2], k=3
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3].
Example 2:
Input: [2, 3, 4, 1, 5], k=2
Output: 7
Explanation: Subarray with maximum sum is [3, 4].
 */
public class MaximumSumSubarrayOfSizeK {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 5};
        int k =2;
        int l = 0;
        int sum =0;
        int max = Integer.MIN_VALUE;
        for(int i= 0;i<arr.length;i++){
            sum += arr[i];

            while(i-l >= k){
                sum -= arr[l];
                l++;
            }
            max= Math.max(max, sum);

        }

        System.out.println(max);
    }
}

