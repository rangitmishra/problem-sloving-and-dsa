package codingPatterns.leetcode;

import java.util.Arrays;

/*
https://leetcode.com/problems/permutation-in-string/description/

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.
 */
public class PermutationInString {

    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        boolean exists = isEqual(s1,s2);
        System.out.println(exists);
    }

    private static boolean isEqual(String s1, String s2) {

        if(s1.length() > s2.length()){
            return false;
        }
        char[] s11 = new char[26];
        char[] s22 = new char[26];

        for(int i=0;i<s1.length();i++){
            s11[s1.charAt(i) - 'a']++;
            s22[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(s11, s22)){
            return true;
        }

        int l = 0;
        for(int i=s1.length();i<s2.length();i++){
            s22[s2.charAt(i) - 'a']++;
            s22[s2.charAt(l) - 'a']--;
            if(Arrays.equals(s11, s22)){
                return true;
            }
            l++;
        }

        return false;
    }
}
