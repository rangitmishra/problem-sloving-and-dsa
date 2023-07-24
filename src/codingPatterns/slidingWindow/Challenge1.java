package codingPatterns.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Problem Challenge 1
Permutation in a String (hard)
Given a string and a pattern, find out if the string contains any permutation of the pattern.
Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:
abc
acb
bac
bca
cab
cba
If a string has ‘n’ distinct characters it will have n!n! permutations.
Example 1:
Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.
Example 2:
Input: String="odicf", Pattern="dc"
Output: false
Explanation: No permutation of the pattern is present in the given string as a substring.
Example 3:
Input: String="bcdxabcdy", Pattern="bcdyabcdx"
Output: true
Explanation: Both the string and the pattern are a permutation of each other.
Example 4:
Input: String="aaacb", Pattern="abc"
Output: true
Explanation: The string contains "acb" which is a permutation of the given pattern.
 */
public class Challenge1 {


    public static void main(String[] args) {
        String str = "bbaa";
        String pattern = "aaa";
        Map<Character, Integer> patCount = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            char c= pattern.charAt(i);
            patCount.put(c, patCount.getOrDefault(c, 0)+1);
        }

        boolean found = false;
        boolean st = true;
        int l = 0;
        int k = pattern.length();
        for(int i=0;i<str.length();i++){
            char c= str.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);

            if(i-l+1 == k){
                st = true;
                for(Map.Entry<Character, Integer> e: patCount.entrySet()){
                    if(!map.containsKey(e.getKey()) || map.get(e.getKey()).intValue() != e.getValue().intValue()){
                        st = false;
                    }
                }
                if(st){
                    found = true;
                }
                char lc = str.charAt(l);
                map.put(lc, map.get(lc)-1);
                if(map.get(lc) == 0){
                    map.remove(lc);
                }
                l++;

            }

        }
        System.out.println(found);
    }
}
