package codingPatterns.topKElemets;

import java.util.PriorityQueue;

/*
Problem Statement
Given an array, find the sum of all numbers between the K1’th and K2’th smallest elements of that array.
Example 1:
Input: [1, 3, 12, 5, 15, 11], and K1=3, K2=6
Output: 23
Explanation: The 3rd smallest number is 5 and 6th smallest number 15. The sum of numbers coming
between 5 and 15 is 23 (11+12).
Example 2:
Input: [3, 5, 8, 7], and K1=1, K2=4
Output: 12
Explanation: The sum of the numbers between the 1st smallest number (3) and the 4th smallest
number (8) is 12 (5+7).
 */
public class SumOfElements {

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 7};
        int k1=1, k2 =4;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }

        int sum =0;
        int cnt = 0;
        while(k2 > 1){
            int p = pq.poll();
            if(cnt == k1){
                sum += p;
            } else {
                cnt++;
            }
            k2--;
        }

        System.out.println(sum);
    }
}
