package codingPatterns;

/*
Input: arr[] = {1, 4, -3, 9, 5, -6}
Output: 14
Explanation:
Subarray [9, 5] is the subarray having maximum sum with all non-negative elements.

Input: arr[] = {12, 0, 10, 3, 11}
Output: 36
 */
public class LargestSubArrayNonNegative {

    public static void main(String[] args) {

        int[] arr = {1, 4, -3, 9, 5, -6};

        int start = 0;
        int end = 0;
        int s = 0;
        int maxTillNow = 0;
        int maxEnding = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > 0){
                maxEnding += arr[i];
            } else {
                maxEnding = 0;
                s = i+1;
            }

            if(maxEnding > maxTillNow){
                maxTillNow = maxEnding;
                start = s;
                end = i;
            }
        }

        System.out.println(maxTillNow);
        System.out.println(String.format("(%s,%s)", start, end));

    }
}
