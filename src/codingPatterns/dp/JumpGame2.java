package codingPatterns.dp;

/*
Minimum jumps to reach end
 arr = [2,3,1,1,2,4,2,0,1,1]
 */
public class JumpGame2
{
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,2,4,2,0,1,1};
        int[] jumps = new int[arr.length];
        for(int i=1;i<arr.length;i++){
            jumps[i] = Integer.MAX_VALUE;
        }

        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(i <= j + arr[j]){
                    jumps[i] = Math.min(1+jumps[j], jumps[i]);
                }
            }
        }

        System.out.println(jumps[arr.length-1]);
    }
}
