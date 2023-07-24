package codingPatterns;

/*
https://www.geeksforgeeks.org/largest-sum-contiguous-increasing-subarray/?ref=rp

Input : arr[] = {2, 1, 4, 7, 3, 6}
Output : 12
Contiguous Increasing subarray {1, 4, 7} = 12

Input : arr[] = {38, 7, 8, 10, 12}
Output : 38

 */
public class LargestSumIncreasingSubarray {
    public static void main(String[] args) {
        int[] arr = {-10,-5,-7,-3,-1};

        int start = 0;
        int end = 0;
        int s = 0;
        int sumEnding = arr[0];
        int maxSum = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i] < 0 || arr[i] < arr[i-1]){
                sumEnding = arr[i];
                s = i;
            } else {
                sumEnding += arr[i];
            }

            if(sumEnding > maxSum){
                maxSum = sumEnding;
                start = s;
                end = i;
            }

        }

        System.out.println(maxSum);
        System.out.println(String.format("(%s,%s)", start, end));
    }
}
