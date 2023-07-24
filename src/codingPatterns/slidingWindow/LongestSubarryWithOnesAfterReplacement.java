package codingPatterns.slidingWindow;

/*
Problem Statement
Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
find the length of the longest contiguous subarray having all 1s.
Example 1:
Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
Output: 6
Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
Example 2:
Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
Output: 9
Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
 */
public class LongestSubarryWithOnesAfterReplacement {

    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        int k = 3;
        int l =0;
        int cnt = 0;
        int ans = Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++) {
            if(arr[i] == 0) {
                cnt++;
            }
            while(cnt > k){
                if(arr[l] == 0){
                    cnt--;
                }
                l++;
            }
            ans = Math.max(ans, i-l+1);
        }

        System.out.println(ans);

    }
}
