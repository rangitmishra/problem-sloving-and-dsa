package codingPatterns.dp;

/*
Input:  mat[][] = {{1, 2, 9}
                   {5, 3, 8}
                   {4, 6, 7}}
Output: 4
The longest path is 6-7-8-9.
 */
public class LongestPathInMatrix {


    public static void main(String[] args) {
        int[][] mat = {{1,2,9},{5,3,8},{4,6,7}};

        int[][] dp = new int[mat.length][mat[0].length];

        for(int i=0;i< dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i=0;i< mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                calculateMax(i,j,mat,dp);
                //System.out.println(dp[i][j]);
                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.println(ans);
    }

    private static int calculateMax(int i, int j, int[][] mat, int[][] dp) {
        if(i<0 || i >= mat.length || j <0 || j >= mat[0].length){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        int d = Integer.MIN_VALUE;

        if(j<mat[0].length-1 && mat[i][j+1] == mat[i][j]+1){
            dp[i][j] = a = 1 + calculateMax(i, j+1, mat, dp);
        }
        if(j>0 && mat[i][j-1] == mat[i][j]+1){
            dp[i][j] = b = 1 + calculateMax(i, j-1, mat, dp);
        }
        if(i<mat[0].length-1 && mat[i+1][j] == mat[i][j]+1){
            dp[i][j] = c = 1 +  calculateMax(i+1, j, mat, dp);
        }
        if(i>0 && mat[i-1][j] == mat[i][j]+1){
            dp[i][j] = d = 1 + calculateMax(i-1, j, mat, dp);
        }

        dp[i][j] =  Math.max(a,Math.max(b,Math.max(c,Math.max(d,1))));
        return dp[i][j];
    }
}
