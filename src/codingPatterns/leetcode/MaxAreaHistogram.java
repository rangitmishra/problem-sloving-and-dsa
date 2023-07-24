package codingPatterns.leetcode;

import java.util.Stack;

public class MaxAreaHistogram {

    public static void main(String[] args) {
        long[] arr = {6,2,5,4,5,1,6};


        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        long ans = Long.MIN_VALUE;

        for(int i=1;i<arr.length;i++){

            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int prev = stack.pop();
                if(!stack.isEmpty()){
                    ans = Math.max((i-stack.peek()-1)*arr[prev], ans);
                } else {
                    ans = Math.max((i-prev)*arr[prev], ans);
                }
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int prev = stack.pop();
            ans = Math.max((arr.length-prev)*arr[prev], ans);
        }

        System.out.println(ans);

    }
}
