package codingPatterns.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Problem Statement #
Given a string, find the length of the longest substring in it with no more than K distinct characters.
Example 1:
Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".
Example 2:
Input: String="araaci", K=1
Output: 2
Explanation: The longest substring with no more than '1' distinct characters is "aa".
Example 3:
Input: String="cbbebi", K=3
Output: 5
Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 */
public class LongestSubstringWithKDistinctCharacters {

    public static void main(String[] args) {
        String str = "cbbebi";
        int k =3;
        int l =0;
        int ans =  Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);

            while(map.size() > k){
                char lc = str.charAt(l);
                if(map.get(lc) == 1){
                    map.remove(lc);
                } else {
                    map.put(lc, map.get(lc)-1);
                }
                l++;
            }
            ans = Math.max(ans, i-l+1);
        }

        System.out.println(ans);
    }
}
