package codingPatterns;

/*
Print sub array also
 */
public class MaximumSubArraySum {

    public static void main(String[] args) {

        int start = 0;
        int end = 0;
        int s = 0;
        int[] arr = {-2,-3,4,-1,-2,1,5,-3};
        int maxTillNow = arr[0];
        int maxEnding = arr[0];
        for(int i=1;i<arr.length;i++){
            maxEnding += arr[i];
            if(maxEnding > maxTillNow){
                maxTillNow = maxEnding;
                start = s;
                end = i;
            }
            if(maxEnding < 0){
                maxEnding = 0;
                s = i+1;
            }
        }
        System.out.println(maxTillNow);
        System.out.println(String.format("(%s,%s)", start, end));

    }
}
