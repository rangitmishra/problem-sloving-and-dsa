package codingPatterns.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://www.geeksforgeeks.org/find-all-unique-subsets-of-a-given-set/

{1, 5, 6}
 */
public class ReturnAllSubset {

    public static void main(String[] args) {

        List<Integer> lst = Arrays.asList(1,5,6);
        List<List<Integer>> ans = getPowerSet(lst);

        System.out.println(ans);
    }

    private static List<List<Integer>> getPowerSet(List<Integer> lst) {

        if(lst.size() == 1){
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(lst);
            ans.add(new ArrayList<>());
            return ans;
        }
        List<List<Integer>> temp = getPowerSet(lst.subList(1, lst.size()));
        List<List<Integer>> ans = new ArrayList<>();
        ans.addAll(temp);
        for(List<Integer>ls: temp){
            List<Integer> dest = copy(ls);
            dest.add(lst.get(0));
            ans.add(dest);
        }

        return ans;

    }

    private static List<Integer> copy(List<Integer> ls){
        List<Integer> lst = new ArrayList<>();
        for (Integer i: ls){
            lst.add(i);
        }
        return lst;
    }
}
