package codingPatterns.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Problem Statement
Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter,
find the length of the longest substring having the same letters after replacement.
Example 1:
Input: String="aabccbb", k=2
Output: 5
Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
Example 2:
Input: String="abbcb", k=1
Output: 4
Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
Example 3:
Input: String="abccde", k=1
Output: 3
Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 */
public class LongestSubstringWithSameLettersAfterReplacement {

    public static void main(String[] args) {
        String str = "abccde";
        int k =1;
        int ans = Integer.MIN_VALUE;
        int l =0;
        int mLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
            if(map.get(c) > mLen){
                mLen = map.get(c);
            }
            if((i-l)+1-mLen > k) {
                char lc = str.charAt(l);
                map.put(lc, map.get(lc)-1);
                l++;
            }
            ans = Math.max(ans, i-l+1);
        }

        System.out.println(ans);

    }
}
