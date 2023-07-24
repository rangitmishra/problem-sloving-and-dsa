package codingPatterns.kwayMerge;

import java.util.*;

/*
Problem Statement
Given ‘M’ sorted arrays, find the K’th smallest number among all the arrays.
Example 1:
Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4], K=5
Output: 4
Explanation: The 5th smallest number among all the arrays is 4, this can be verified from the merged
list of all the arrays: [1, 2, 3, 3, 4, 6, 6, 7, 8]
Example 2:
Input: L1=[5, 8, 9], L2=[1, 7], K=3
Output: 7
Explanation: The 3rd smallest number among all the arrays is 7.
 */
public class KthSmallestNumberInMSortedList {

    public static class Pair {
        public int n;
        public int idx;
        public int val;
        public Pair(int n, int idx, int val){
            this.n = n;
            this.idx = idx;
            this.val = val;
        }

    }

    public static void main(String[] args) {
        int k = 3;
        List<List<Integer>> lst = new ArrayList<>();
        List<Integer> lst1 = Arrays.asList(5, 8, 9);
        List<Integer> lst2 = Arrays.asList(1, 7);
        //List<Integer> lst3 = Arrays.asList(1, 3, 4);

        lst.add(lst1);
        lst.add(lst2);
        //lst.add(lst3);

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.val - o2.val;
            }
        });

        for(int i=0;i<lst.size();i++){
            Pair p = new Pair(i, 0, lst.get(i).get(0));
            pq.add(p);
        }

        int cnt = 0;
        while(cnt < k-1) {
            Pair p = pq.poll();
            if(p.idx + 1 < lst.get(p.n).size()) {
                pq.add(new Pair(p.n, p.idx+1, lst.get(p.n).get(p.idx+1)));
            }
            cnt++;
        }

        Pair p = pq.poll();
        System.out.println(p.val);

    }
}
