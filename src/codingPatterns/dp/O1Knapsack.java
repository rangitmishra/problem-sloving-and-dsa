package codingPatterns.dp;

/*
Introduction
Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack which has a capacity ‘C’.
The goal is to get the maximum profit out of the items in the knapsack.
Each item can only be selected once, as we don’t have multiple quantities of any item.
Let’s take the example of Merry, who wants to carry some fruits in the knapsack to get maximum profit.
    Here are the weights and profits of the fruits:
Items: { Apple, Orange, Banana, Melon }
Weights: { 2, 3, 1, 4 }
Profits: { 4, 5, 3, 7 }
Knapsack capacity: 5
Let’s try to put various combinations of fruits in the knapsack, such that their total weight is not more than 5:
Apple + Orange (total weight 5) => 9 profit
Apple + Banana (total weight 3) => 7 profit
Orange + Banana (total weight 4) => 8 profit
Banana + Melon (total weight 5) => 10 profit
This shows that Banana + Melon is the best combination as it gives us the maximum profit and the total weight does not exceed the capacity.
 */
public class O1Knapsack {

    public static void main(String[] args) {

        //       0  1  2  3  4  5
        //4/2    0  0  4  4  4  4
        //5/3    0  0  4  5  5  9
        //3/1    0  3  4  7  8  9
        //7/4    0  3  4  7  8  10


        int[] profit = {4,5,3,7};
        int[] weight = {2,3,1,4};
        int capacity = 5;

        int dp[][] = new int[weight.length+1][capacity+1];
        for(int i=0;i<weight.length;i++){
            for(int j=1;j<=capacity;j++){
                if(weight[i] > j){
                    dp[i+1][j] = dp[i][j];
                } else {
                    dp[i+1][j] = Math.max(dp[i][j], profit[i] + dp[i][j-weight[i]]);
                }
            }
        }

        System.out.println("Max profit = " + dp[weight.length][capacity]);
    }
}
