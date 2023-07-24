package codingPatterns.slidingWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Problem Statement
Given a string, find the length of the longest substring which has no repeating characters.
Example 1:
Input: String="aabccbb"
Output: 3
Explanation: The longest substring without any repeating characters is "abc".
Example 2:
Input: String="abbbb"
Output: 2
Explanation: The longest substring without any repeating characters is "ab".
Example 3:
Input: String="abccde"
Output: 3
Explanation: Longest substrings without any repeating characters are "abc" & "cde".
 */
public class NoRepeatSubstring {

    public static void main(String[] args) {
        String str = "abccde";
        int l = 0;
        Set<Character> set = new HashSet<>();
        int ans = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        for(int i=0;i<str.length();i++){
            while(set.contains(str.charAt(i))){
                set.remove(str.charAt(l));
                l++;
            }
            set.add(str.charAt(i));
            //ans = Math.max(ans, set.size());
            if(set.size() >= ans){
                ans = set.size();
                start = l;
                end = i;
            }
        }

        System.out.println(ans);
        System.out.println(str.substring(start,end+1));
    }
}
