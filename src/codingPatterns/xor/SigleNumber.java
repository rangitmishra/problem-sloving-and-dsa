package codingPatterns.xor;

/*
Problem Statement
In a non-empty array of integers, every number appears twice except for one, find that single number.
Example 1:
Input: 1, 4, 2, 1, 3, 2, 3
Output: 4
Example 2:
Input: 7, 9, 7
Output: 9
 */
public class SigleNumber {

    public static void main(String[] args) {
        int[] arr = {7, 9, 7};
        int singleNo = arr[0];
        for(int i=1;i<arr.length;i++) {
            singleNo = singleNo ^ arr[i];
        }
        System.out.println(singleNo);
    }
}
