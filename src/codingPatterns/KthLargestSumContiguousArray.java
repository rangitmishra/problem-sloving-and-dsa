package codingPatterns;

import java.util.PriorityQueue;

/*
Input: a[] = {20, -5, -1}
         k = 3
Output: 14
Explanation: All sum of contiguous
subarrays are (20, 15, 14, -5, -6, -1)
so the 3rd largest sum is 14.

Input: a[] = {10, -10, 20, -40}
         k = 6
Output: -10
Explanation: The 6th largest sum among
sum of all contiguous subarrays is -10.
 */
public class KthLargestSumContiguousArray {

    public static void main(String[] args) {
        int[] arr = {10, -10, 20, -40};
        int k = 6;

        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            sum[i] = sum[i-1] + arr[i];
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int s = sum[j] - sum[i] + arr[i];

                if(pq.size() < k){
                    pq.add(s);
                } else {
                    int a = pq.peek();
                    if(s > a){
                        pq.poll();
                        pq.add(s);
                    }
                }

            }
        }

        System.out.println(pq.peek());
    }
}
