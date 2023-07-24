package codingPatterns.cyclicSort;

/*
Problem Statement
We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.
Example 1:
Input: [4, 0, 3, 1]
Output: 2
Example 2:
Input: [8, 3, 5, 2, 4, 6, 0, 1]
Output: 7
 */
public class FindTheMissingNumber {

    public static void main(String[] args) {

        int[] arr = {8, 3, 5, 2, 4, 7, 0, 1};
        int n = arr.length;

        for(int i=0;i<arr.length;i++) {
            if(arr[i] != arr.length && arr[i] != i) {
                int x = arr[i];
                int temp = arr[x];
                arr[x] = arr[i];
                arr[i] = temp;
                i--;
            }
        }

        for(int i=0;i<arr.length;i++) {
            if(arr[i] != i){
                System.out.println(i);
                break;
            }

        }
    }
}
