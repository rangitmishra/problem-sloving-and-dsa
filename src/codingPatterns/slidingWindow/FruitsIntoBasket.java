package codingPatterns.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 *         Problem Statement
 *         Given an array of characters where each character represents a fruit tree,
 *         you are given two baskets and your goal is to put maximum number of fruits in each basket.
 *         The only restriction is that each basket can have only one type of fruit.
 *         You can start with any tree, but once you have started you can’t skip a tree.
 *         You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
 *         Write a function to return the maximum number of fruits in both the baskets.
 *         Example 1:
 *         Input: Fruit=['A', 'B', 'C', 'A', 'C']
 *         Output: 3
 *         Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 *         Example 2:
 *         Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
 *         Output: 5
 *         Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
 *         This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
 */

public class FruitsIntoBasket {

    public static void main(String[] args) {

        char[] arr = {'A', 'B', 'C', 'A', 'C'};
        int l = 0;
        int ans = Integer.MIN_VALUE;

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            char c = arr[i];
            map.put(c, map.getOrDefault(c, 0)+1);

            while (map.size() > 2){
                char lf = arr[l];
                if(map.get(lf) == 1){
                    map.remove(lf);
                } else {
                    map.put(lf, map.get(lf)-1);
                }
                l++;
            }

            ans = Math.max(ans, i-l);
        }
        ans = Math.max(ans, arr.length-l);

        System.out.println(ans);

    }
}
