package codingPatterns.xor;

/*
Problem Statement
Every non-negative integer N has a binary representation, for example, 8 can be represented as “1000” in binary and 7 as “0111” in binary.
The complement of a binary representation is the number in binary that we get when we change every 1 to a 0 and every 0 to a 1.
For example, the binary complement of “1010” is “0101”.
For a given positive number N in base-10, return the complement of its binary representation as a base-10 integer.
Example 1:
Input: 8
Output: 7
Explanation: 8 is 1000 in binary, its complement is 0111 in binary, which is 7 in base-10.
Example 2:
Input: 10
Output: 5
Explanation: 10 is 1010 in binary, its complement is 0101 in binary, which is 5 in base-10.
 */
public class ComplementBase10 {

    public static void main(String[] args) {
        int n = 10;

        int mask = 1;

        while(mask < n) {
            mask = (mask << 1) + 1;
        }

        int ans = mask ^ n;
        System.out.println(ans);
    }
}
