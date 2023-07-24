package codingPatterns.modifyBinarySearch;

/*
Problem Statement
Given an array of numbers sorted in ascending order, find the range of a given number ‘key’.
The range of the ‘key’ will be the first and last position of the ‘key’ in the array.
Write a function to return the range of the ‘key’. If the ‘key’ is not present return [-1, -1].
Example 1:
Input: [4, 6, 6, 6, 9], key = 6
Output: [1, 3]
Example 2:
Input: [1, 3, 8, 10, 15], key = 10
Output: [3, 3]
Example 3:
Input: [1, 3, 8, 10, 15], key = 12
Output: [-1, -1]
 */
public class NumberRange {


    public static void main(String[] args) {
        int[] arr = {4, 6, 6, 6, 9};
        int k = 6;

        int idx = getKey(arr, k);
        if(idx != -1){
            int lidx = getLidx(idx, k, arr);
            int ridx = getRidx(idx, k, arr);
            System.out.println(String.format("(%s,%s)",lidx, ridx));
        } else {
            System.out.println(String.format("(%s,%s)",-1, -1));
        }

    }

    private static int getLidx(int i, int k, int[] arr) {
        int l =0;
        int r = i;
        while(l <= r){
            int mid = (l+r)/2;
            if(arr[mid+1] == k && arr[mid] < arr[mid+1]){
                return mid+1;
            }
            if(arr[mid] < k){
                l = mid+1;
            } else {
                r = mid-1;
            }

        }
        return l;
    }

    private static int getRidx(int i, int k, int[] arr) {
        int l = i;
        int r = arr.length-1;

        while(l <= r){
            int mid = (l+r)/2;
            if(arr[mid] == k && arr[mid] < arr[mid+1]){
                return mid;
            }
            if(arr[mid] > k){
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        return l;
    }

    private static int getKey(int[] arr, int k) {

        int l = 0;
        int r = arr.length;

        while(l <= r){
            int mid = (l+r)/2;

            if(arr[mid] == k){
                return mid;
            }
            if(arr[mid] > k){
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        return -1;
    }
}
