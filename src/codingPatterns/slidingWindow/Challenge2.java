package codingPatterns.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Problem Challenge 2
String Anagrams (hard)
Given a string and a pattern, find all anagrams of the pattern in the given string.
Anagram is actually a Permutation of a string. For example, “abc” has the following six anagrams:
abc
acb
bac
bca
cab
cba
Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
Example 1:
Input: String="ppqp", Pattern="pq"
Output: [1, 2]
Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
Example 2:
Input: String="abbcabc", Pattern="abc"
Output: [2, 3, 4]
Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
 */
public class Challenge2 {

    public static void main(String[] args) {
        String str = "abbcabc";
        String pattern = "abc";
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();


        for(int i=0;i<pattern.length();i++){
            char c = pattern.charAt(i);
            pMap.put(c, pMap.getOrDefault(c, 0)+1);
        }

        int l =0;

        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
            if(i-l+1 == pattern.length()){
                boolean f = true;
                for(Map.Entry<Character, Integer> e: pMap.entrySet()){
                    if(!map.containsKey(e.getKey()) || map.get(e.getKey()).intValue() != e.getValue().intValue()){
                        f = false;
                    }
                }
                if(f){
                    ans.add(l);
                }
                char lc = str.charAt(l);
                map.put(lc, map.get(lc)-1);
                if(map.get(lc) == 0){
                    map.remove(lc);
                }
                l++;
            }


        }

        System.out.println(ans);

    }
}
