package codingPatterns.modifyBinarySearch;

/*
Problem Statement
Find the maximum value in a given Bitonic array. An array is considered bitonic if it is monotonically increasing
and then monotonically decreasing. Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].
Example 1:
Input: [1, 3, 8, 12, 4, 2]
Output: 12
Explanation: The maximum number in the input bitonic array is '12'.
Example 2:
Input: [3, 8, 3, 1]
Output: 8
Example 3:
Input: [1, 3, 8, 12]
Output: 12
Example 4:
Input: [10, 9, 8]
Output: 10
 */
public class BitonicArray {

    public static void main(String[] args) {
        //           0  1  2   3  4  5
        int[] arr = {10, 9, 8};

        int l = 0;
        int r = arr.length-1;

        while(l < r){
            int mid = (l+r)/2;
            if(arr[mid] > arr[mid+1]){
                r = mid;
            } else {
                l = mid+1;
            }
        }

        System.out.println(arr[r]);
    }
}
