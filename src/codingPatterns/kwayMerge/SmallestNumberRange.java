package codingPatterns.kwayMerge;

import java.util.*;

/*
Problem Statement
Given ‘M’ sorted arrays, find the smallest range that includes at least one number from each of the ‘M’ lists.
Example 1:
Input: L1=[1, 5, 8], L2=[4, 12], L3=[7, 8, 10]
Output: [4, 7]
Explanation: The range [4, 7] includes 5 from L1, 4 from L2 and 7 from L3.
Example 2:
Input: L1=[1, 9], L2=[4, 12], L3=[7, 10, 16]
Output: [9, 12]
Explanation: The range [9, 12] includes 9 from L1, 12 from L2 and 10 from L3.
 */
public class SmallestNumberRange {

    public static class Pair {
        public int n;
        public int idx;

        public int val;

        public Pair(int n, int idx, int val){
            this.n = n;
            this.idx = idx;
            this.val = val;
        }

        public int equals(Pair p){
            return this.val - p.val;
        }
    }


    public static void main(String[] args) {

        List<List<Integer>> lst = new ArrayList<>();
        List<Integer> lst1 = Arrays.asList(1, 9);
        List<Integer> lst2 = Arrays.asList(4, 12);
        List<Integer> lst3 = Arrays.asList(7, 10, 16);
        lst.add(lst1);
        lst.add(lst2);
        lst.add(lst3);

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.val - o2.val;
            }
        });

        int max = Integer.MIN_VALUE;
        for(int i=0;i<lst.size();i++){
            Pair p = new Pair(i, 0, lst.get(i).get(0));
            max = Math.max(max, lst.get(i).get(0));
            pq.add(p);
        }

        int rl = Integer.MAX_VALUE;
        int rr = max;
        int diff = Integer.MAX_VALUE;

        while(true){
            Pair p = pq.poll();
            int d = max - p.val;
            if(d < diff){
                diff = d;
                rl = p.val;
                rr = max;
            }
            if(lst.get(p.n).size() == p.idx + 1){
                break;
            } else {
                pq.add(new Pair(p.n, p.idx+1, lst.get(p.n).get(p.idx+1)));
                if(lst.get(p.n).get(p.idx+1) > max){
                    max = lst.get(p.n).get(p.idx+1);
                }
            }

        }

        System.out.println("[" + rl + "," + rr + "]");



    }
}
