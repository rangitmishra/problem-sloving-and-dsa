package codingPatterns.leetcode;

/*
--> left to right find max product
--> right to left find max product
whichever is greater will be greater
 */
public class SubArrayWithMaxProduct {

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int prdSoFar = nums[0]==0 ? 1: nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i] == 0){
                prdSoFar = 1;
            } else {
                prdSoFar = nums[i]*prdSoFar;
            }
            max = Math.max(max, nums[i]*prdSoFar);
        }

        prdSoFar = nums[nums.length-1] == 0 ? 1 : nums[nums.length-1];
        max = Math.max(max, nums[nums.length-1]);
        for(int i=nums.length - 2;i>=0;i--){
            if(nums[i] == 0){
                prdSoFar = 1;
            } else {
                prdSoFar = nums[i]*prdSoFar;
            }
            max = Math.max(max, nums[i]*prdSoFar);

        }

        return max;

    }
}
