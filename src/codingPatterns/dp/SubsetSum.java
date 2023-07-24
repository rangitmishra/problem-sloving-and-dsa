package codingPatterns.dp;

/*
Problem Statement
Given a set of positive numbers, determine if a subset exists whose sum is equal to a given number ‘S’.
Example 1:
Input: {1, 2, 3, 7}, S=6
Output: True
The given set has a subset whose sum is '6': {1, 2, 3}
Example 2:
Input: {1, 2, 7, 1, 5}, S=10
Output: True
The given set has a subset whose sum is '10': {1, 2, 7}
Example 3:
Input: {1, 3, 4, 8}, S=6
Output: False
The given set does not have any subset whose sum is equal to '6'.
 */
public class SubsetSum {

    public static void main(String[] args) {
        //    0  1 2 3 4 5 6
        //    T  F F F F F F
        //1   T  T F F F F F
        //3   T  T F T T F F
        //4   T T  F T T T F
        //8   T T  F

        int[] nums = {1, 3, 4, 8};
        int s = 6;
        boolean[][] dp = new boolean[nums.length+1][s+1];
        dp[0][0] = true;


        for(int i=0;i<nums.length;i++){
            for(int j=0;j<s+1;j++){
                if(j ==0){
                    dp[i+1][0] = true;
                }
                if(nums[i] <= j){
                    dp[i+1][j] = dp[i][j] || dp[i][j-nums[i]];
                } else {
                    dp[i+1][j] = dp[i][j];
                }
            }
        }

        for(int i=0;i<nums.length+1;i++){
            for(int j=0;j<s+1;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(dp[nums.length][s]);
    }
}
