package codingPatterns.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
given array of int[2,3,1]

and array of different operators = {+, -, *}

compute all possible result

 */
public class NumberAndOperators {

    public static void main(String[] args) {
        int[] arr = {2,3,1};
        // operators allowed +, - , *
        List<Integer> ans = getResult(arr, arr.length-1);
        System.out.println(Arrays.toString(ans.toArray()));
    }

    private static List<Integer> getResult(int[] arr, int index) {

        if(index == 0){
            List<Integer> ans = new ArrayList<>();
            ans.add(arr[index]);
            return ans;
        }
        List<Integer> answerWithExclude = getResult(arr, index-1);
        List<Integer> ans = new ArrayList<>();
        for(int num: answerWithExclude){
            ans.add(num + arr[index]);
            ans.add(num - arr[index]);
            ans.add(num * arr[index]);
        }
        return ans;

    }
}
