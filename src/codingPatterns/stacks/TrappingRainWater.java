package codingPatterns.stacks;

import java.util.Arrays;
import java.util.Stack;

/*
Input: arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
Output: 6
 */
public class TrappingRainWater {


    public static void main(String[] args) {
        int[] water = {2,0,2};

        int ans = getWaterTrapped(water);
        System.out.println(ans);
    }

    private static int getWaterTrapped(int[] blocks) {

        int[] ngeLeft = new int[blocks.length];
        int[] ngeRight = new int[blocks.length];


        Stack<Integer> stack = new Stack<>();
        stack.add(blocks[blocks.length-1]);
        for(int i=blocks.length-1;i>0;i--){
            if(blocks[i]<stack.peek()){
                ngeRight[i] = stack.peek();
            } else {
                stack.pop();
                stack.push(blocks[i]);
            }
        }

        stack.clear();
        stack.push(blocks[0]);
        for(int i=1;i<blocks.length;i++){
            if(blocks[i]<stack.peek()){
                ngeLeft[i] = stack.peek();
            } else {
                stack.pop();
                stack.push(blocks[i]);
            }
        }

        System.out.println(Arrays.toString(ngeRight));
        System.out.println(Arrays.toString(ngeLeft));

        int sum = 0;
        for(int i=1;i<blocks.length-1;i++){
            int upperLevel = Math.min(ngeRight[i], ngeLeft[i]);
            if(blocks[i] < upperLevel){
                sum += upperLevel - blocks[i];
            }
        }


        return sum;
    }
}
