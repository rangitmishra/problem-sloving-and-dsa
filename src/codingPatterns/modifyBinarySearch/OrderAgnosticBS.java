package codingPatterns.modifyBinarySearch;

/*
Problem Statement
Given a sorted array of numbers, find if a given number ‘key’ is present in the array.
Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order.
You should assume that the array can have duplicates.
Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.
Example 1:
Input: [4, 6, 10], key = 10
Output: 2
Example 2:
Input: [1, 2, 3, 4, 5, 6, 7], key = 5
Output: 4
Example 3:
Input: [10, 6, 4], key = 10
Output: 0
Example 4:
Input: [10, 6, 4], key = 4
Output: 2
 */
public class OrderAgnosticBS {

    public static void main(String[] args) {

        int[] arr = {10, 6, 4};
        int k = 4;

        int ans = search(arr, k);
        System.out.println(ans);
    }

    public static int search(int[] arr, int k){
        int l = 0;
        int r = arr.length-1;
        while(l <= r){
            int mid = (l+r)/2;
            if(arr[mid] == k) {
                return mid;
            }
            if(arr[0] < arr[arr.length-1]){
                if(k > arr[mid]){
                    l = mid+1;
                } else {
                    r = mid-1;
                }
            } else {
                if(k > arr[mid]){
                    r = mid-1;
                } else {
                    l = mid+1;
                }

            }

        }
        return -1;

    }
}
