package codingPatterns.topKElemets;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Problem Statement
Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.
Example 1:
Input: [1, 3, 5, 12, 11, 12, 11], K = 2
Output: [12, 11]
Explanation: Both '11' and '12' apeared twice.
Example 2:
Input: [5, 12, 11, 3, 11], K = 2
Output: [11, 5] or [11, 12] or [11, 3]
Explanation: Only '11' appeared twice, all other numbers appeared once.
 */
public class TopKFrequentNumbers {

    public static class FrqncyMp{
        int n;
        int count;
        public FrqncyMp(int n, int count){
            this.n = n;
            this.count = count;
         }
    }
    public static void main(String[] args) {

        int[] arr = {5, 12, 11, 3, 11};
        int k = 2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        PriorityQueue<FrqncyMp> pq = new PriorityQueue<>(new Comparator<FrqncyMp>() {
            @Override
            public int compare(FrqncyMp o1, FrqncyMp o2) {
                return o1.count - o2.count;
            }
        });
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            FrqncyMp a = new FrqncyMp(entry.getKey(), entry.getValue());
            if(pq.size()==k){
                if(entry.getValue() > pq.peek().count) {
                    pq.poll();
                    pq.add(a);
                }
            } else{
                pq.add(a);
            }
        }

        while (pq.size()>0){
            System.out.println(pq.poll().n);
        }

    }
}
