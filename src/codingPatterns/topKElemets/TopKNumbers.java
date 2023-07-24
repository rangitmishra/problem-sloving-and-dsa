package codingPatterns.topKElemets;

import java.util.Collections;
import java.util.PriorityQueue;

/*
Problem Statement
Given an unsorted array of numbers, find the ‘K’ largest numbers in it.
Note: For a detailed discussion about different approaches to solve this problem, take a look at Kth Smallest Number.
Example 1:
Input: [3, 1, 5, 12, 2, 11], K = 3
Output: [5, 12, 11]
Example 2:
Input: [5, 12, 11, -1, 12], K = 3
Output: [12, 11, 12]
 */
public class TopKNumbers {
    public static void main(String[] args) {
        int[] arr = {5, 12, 11, -1, 12};
        int k = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        int cnt = 0;
        while(cnt < k){
            System.out.println(pq.poll());
            cnt++;
        }
    }
}
