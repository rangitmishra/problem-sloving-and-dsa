package codingPatterns.greedy;

import java.util.Map;

/*
Given a positive integer N and a list of N integers A[]. Each element in the array denotes the maximum length
of jump you can cover. Find out if you can make it to the last index if you start at the first index of the list.

Input:
N = 6
A[] = {1, 2, 0, 3, 0, 0}
Output:
1
Explanation:
Jump 1 step from first index to
second index. Then jump 2 steps to reach
4th index, and now jump 2 steps to reach
the end.

Input:
N = 3
A[] =  {1, 0, 2}
Output:
0
Explanation:
You can't reach the end of the array.
 */
public class JumpGame1 {

    public static void main(String[] args) {

        int[] arr = {1,0,2};
        boolean isReached = isReachable(arr);
        System.out.println(isReached);

    }

    private static boolean isReachable(int[] arr) {
        int maxReached = 0;
        for(int i = 0; i< arr.length; i++){
            if(maxReached < i){
                return false;
            }
            int reach = arr[i] + i;
            maxReached = Math.max(reach, maxReached);
        }
        return true;
    }
}
