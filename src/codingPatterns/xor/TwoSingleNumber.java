package codingPatterns.xor;

/*
Problem Statement
In a non-empty array of numbers, every number appears exactly twice except two numbers that appear only once.
Find the two numbers that appear only once.
Example 1:
Input: [1, 4, 2, 1, 3, 5, 6, 2, 3, 5]
Output: [4, 6]
Example 2:
Input: [2, 1, 3, 2]
Output: [1, 3]
 */
public class TwoSingleNumber {

    public static void main(String[] args) {
        int xxory = 0;
        int[] arr = {2, 1, 3, 2};

        for(int a: arr) {
            xxory = xxory ^ a;
        }

        int rbmask = xxory & -xxory;

        int x = 0;
        int y = 0;
        for(int a: arr) {
            if((a & rbmask) == 0) {
                x = x ^ a;
            } else {
                y = y ^ a;
            }
        }
        System.out.println(x);
        System.out.println(y);
    }
}
