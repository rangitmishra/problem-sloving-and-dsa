package codingPatterns.stacks;

import java.util.Arrays;
import java.util.Stack;

public class NGE {

    public static void main(String[] args) {


        int[] arr = {1,2,3,1,4,7,2,5,10};
        int[] ngeRight = new int[arr.length];
        int[] ngeLeft = new int[arr.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i=1;i<arr.length;i++){

            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                ngeRight[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        stack.clear();
        stack.push(arr.length-1);

        for(int i=arr.length-2;i>0;i--){
            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                ngeLeft[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        System.out.println(Arrays.toString(ngeRight));
        System.out.println(Arrays.toString(ngeLeft));
    }
}
