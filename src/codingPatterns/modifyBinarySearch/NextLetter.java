package codingPatterns.modifyBinarySearch;

/*
Problem Statement
Given an array of lowercase letters sorted in ascending order,
find the smallest letter in the given array greater than a given ‘key’.
Assume the given array is a circular list, which means that the last letter is assumed to be connected with the first letter.
This also means that the smallest letter in the given array is greater than the last letter of the array and is also the first letter of the array.
Write a function to return the next letter of the given ‘key’.
Example 1:
Input: ['a', 'c', 'f', 'h'], key = 'f'
Output: 'h'
Explanation: The smallest letter greater than 'f' is 'h' in the given array.
Example 2:
Input: ['a', 'c', 'f', 'h'], key = 'b'
Output: 'c'
Explanation: The smallest letter greater than 'b' is 'c'.
Example 3:
Input: ['a', 'c', 'f', 'h'], key = 'm'
Output: 'a'
Explanation: As the array is assumed to be circular, the smallest letter greater than 'm' is 'a'.
Example 4:
Input: ['a', 'c', 'f', 'h'], key = 'h'
Output: 'a'
Explanation: As the array is assumed to be circular, the smallest letter greater than 'h' is 'a'.
 */
public class NextLetter {

    public static void main(String[] args) {

        char[] arr = {'a','c','f','h'};
        char key = 'h';
        int l =0;
        int r = arr.length-1;
        while(l < r){
            int mid = (l+r)/2;
            if(arr[mid] <= key){
                l = mid+1;
            } else {
                r =mid;
            }
        }

        if(arr[r] > key){
            System.out.println(arr[r]);
        } else if (r == arr.length-1){
            System.out.println(arr[0]);
        }
    }
}
