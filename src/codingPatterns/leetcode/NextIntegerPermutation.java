package codingPatterns.leetcode;

/*
The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
More formally, if all the permutations of the array are sorted in one container according to their lexicographical order,
then the next permutation of that array is the permutation that follows it in the sorted container.
If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order)

Given an array of integers nums, find the next permutation of nums.
The replacement must be in place and use only constant extra memory.

Solution approach
Step 1:In first for loop, traverse the array from the end to find the first decreasing element from the right.
(If any of the element had not been found means, just reverse the loop and exit the program.)

Step 2:In second for loop, traverse the array from the end to find the first element which is greater than the element we had found before.

Step 3:Swap the two elements we had found and stored previously.

Step 4:Just reverse the array from the index next to the first swapped element to the end.
 */
public class NextIntegerPermutation {
    public static void main(String[] args) {

    }
}
