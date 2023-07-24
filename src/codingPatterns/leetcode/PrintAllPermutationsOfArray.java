package codingPatterns.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://www.geeksforgeeks.org/iterative-approach-to-print-all-permutations-of-an-array/
{0, 1, 2}
 */
public class PrintAllPermutationsOfArray {

    public static void main(String[] args) {
        int[] arr = {0,1,2,3};
        String str = "0123";
        List<String> ans = printPermutation(str);
        System.out.println(Arrays.toString(ans.toArray()));
        System.out.println(ans.size());
    }

    private static List<String> printPermutation(String str) {
        if(str.length() == 2){
            List<String> ans = new ArrayList<>();
            ans.add(str);
            StringBuilder strRev = new StringBuilder(str);
            ans.add(strRev.reverse().toString());
            return ans;
        }

        List<String> lst = printPermutation(str.substring(1));
        List<String> ans = new ArrayList<>();
        for(String word: lst){
            for(int i=1;i<word.length();i++){
                StringBuilder neuStr = new StringBuilder(word.substring(0,i));
                neuStr.append(str.charAt(0));
                neuStr.append(word.substring(i));
                ans.add(neuStr.toString());
            }
            ans.add(word+str.charAt(0));
            ans.add(str.charAt(0)+word);
        }

        return ans;

    }
}
