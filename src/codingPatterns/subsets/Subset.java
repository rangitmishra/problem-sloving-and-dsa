package codingPatterns.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Statement
Given a set with distinct elements, find all of its distinct subsets.
Example 1:
Input: [1, 3]
Output: [], [1], [3], [1,3]
Example 2:
Input: [1, 5, 3]
Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]
 */
public class Subset {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1,5,3);

        List<List<Integer>> lst = new ArrayList<>();
        lst.add(new ArrayList<>());

        for(int num: nums){
            List<List<Integer>> subList = getCopy(lst);
            for(int i=0;i<subList.size();i++){
                subList.get(i).add(num);
            }
            lst.addAll(subList);
        }

        System.out.println(lst);

    }

    private static List<List<Integer>> getCopy(List<List<Integer>> lst){
        if(lst == null){
            return null;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> ls: lst){
            List<Integer> a = new ArrayList<>();
            for(Integer i: ls){
                a.add(i);
            }
            ans.add(a);
        }

        return ans;

    }
}
