package codingPatterns.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
https://www.geeksforgeeks.org/word-break-problem-dp-32/
Consider the following dictionary
{ i, like, sam, sung, samsung, mobile, ice,
  cream, icecream, man, go, mango}

Input:  ilike
Output: Yes
The string can be segmented as "i like".

Input:  ilikesamsung
Output: Yes
The string can be segmented as "i like samsung"
or "i like sam sung".
 */
public class WordBreakProblem {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>(Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile", "ice","cream",
                "icecream", "man", "go", "mango"));
        String input = "ilikesamsunggomango";

        boolean[] dp = new boolean[input.length()+1];
        dp[0] = true;

        int n = input.length();
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(dp[j]&&set.contains(input.substring(j,i+1))){
                    dp[i+1] = true;
                }
            }
        }
        System.out.println(dp[input.length()]);

    }
}
