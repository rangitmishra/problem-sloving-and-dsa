package codingPatterns.topKElemets;

import java.util.PriorityQueue;

/*
Problem Statement
Given ‘N’ ropes with different lengths, we need to connect these ropes into one big rope with minimum cost.
The cost of connecting two ropes is equal to the sum of their lengths.
Example 1:
Input: [1, 3, 11, 5]
Output: 33
Explanation: First connect 1+3(=4), then 4+5(=9), and then 9+11(=20). So the total cost is 33 (4+9+20)
Example 2:
Input: [3, 4, 5, 6]
Output: 36
Explanation: First connect 3+4(=7), then 5+6(=11), 7+11(=18). Total cost is 36 (7+11+18)
Example 3:
Input: [1, 3, 11, 5, 2]
Output: 42
Explanation: First connect 1+2(=3), then 3+3(=6), 6+5(=11), 11+11(=22). Total cost is 42 (3+6+11+22)
 */
public class ConnectRopes {

    public static void main(String[] args) {
        int[] arr = {1, 3, 11, 5, 2};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }

        int ans = 0;
        while(pq.size() > 1) {
            int sum = pq.poll() + pq.poll();
            ans += sum;
            pq.add(sum);
        }
        System.out.println(ans);
    }
}
