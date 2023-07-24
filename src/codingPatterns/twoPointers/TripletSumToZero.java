package codingPatterns.twoPointers;

import java.util.Arrays;

/*
Problem Statement
Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
Example 1:
Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
Explanation: There are four unique triplets whose sum is equal to zero.
Example 2:
Input: [-5, 2, -1, -2, 3]
Output: [[-5, 2, 3], [-2, -1, 3]]
Explanation: There are two unique triplets whose sum is equal to zero.
 */
public class TripletSumToZero {

    public static void main(String[] args) {
        //int[] arr = {-3,0,1,2,-1,1,-2};
        //int[] arr = {-5, 2, -1, -2, 3};
        int[] arr = {-5, 2, -1, -2, 3,-5,-1,3};
        Arrays.sort(arr);

        for(int i=0;i<arr.length-2;i++){
            if(i>0 && arr[i-1] == arr[i]){
                continue;
            }
            int start = i+1;
            int end = arr.length-1;
            while(start<end){
                if (arr[i]+ arr[start] + arr[end] > 0) {
                    end--;
                }else if(arr[i]+ arr[start] + arr[end] < 0){
                    start++;
                } else {
                    System.out.println(arr[i] + ", " + arr[start] + ", " + arr[end]);
                    start++;
                    end--;
                    while(start<end && arr[start-1] == arr[start]){
                        start++;
                    }
                    while(start<end && arr[end] == arr[end+1]){
                        end--;
                    }
                }
            }
        }
    }
}
/*
complexity = nlogn + n^2
 */
