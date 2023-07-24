package codingPatterns.dp;

import java.util.Map;

public class LongestPallindromicSubSequence {

    public static void main(String[] args) {
        String str = "acbdbma";

        int n = str.length();
        int[][] dp = new int[n][n];

        for(int i=0;i<n;i++){
            dp[i][i] = 1;
            if(i<n-1){
                dp[i][i+1] = str.charAt(i) == str.charAt(i+1)? 2: 1;
            }
        }
        for(int i=2;i<n;i++){
            for(int j=0;j+i<n;j++){
                int k = j+i;
                dp[j][k] = Math.max(dp[j][k-1], dp[j+1][k]);
                if(str.charAt(j) == str.charAt(k)){
                    dp[j][k] = Math.max(dp[j+1][k-1]+2, dp[j][k]);
                }
            }
        }



        printMatrix(dp);
    }









    private static void printMatrix(int[][] dp) {
        int n = dp.length;
        int m = dp[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
