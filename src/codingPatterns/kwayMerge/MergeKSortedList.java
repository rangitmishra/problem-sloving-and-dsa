package codingPatterns.kwayMerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Statement
Given an array of ‘K’ sorted LinkedLists, merge them into one sorted list.
Example 1:
Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4]
Output: [1, 2, 3, 3, 4, 6, 6, 7, 8]
Example 2:
Input: L1=[5, 8, 9], L2=[1, 7]
Output: [1, 5, 7, 8, 9]
 */
public class MergeKSortedList {

    public static void main(String[] args) {
        List<List<Integer>> lst = new ArrayList<>();
        List<Integer> lst1 = Arrays.asList(2, 6, 8);
        List<Integer> lst2 = Arrays.asList(3, 6, 7);
        List<Integer> lst3 = Arrays.asList(1, 3, 4);
        lst.add(lst1);
        lst.add(lst2);
        lst.add(lst3);

        List<Integer> ans = new ArrayList<>();

        int[] pointers = new int[lst.size()];

        boolean isComplete = false;

        while(!isComplete){
            int pnt = 0;
            for(int i=1;i<lst.size();i++){
                if(pointers[i] < lst.get(i).size() && pointers[pnt] < lst.get(pnt).size() &&
                        (lst.get(i).get(pointers[i]) <= lst.get(pnt).get(pointers[pnt]))) {
                    pnt = i;
                }
            }
            ans.add(lst.get(pnt).get(pointers[pnt]));
            pointers[pnt]++;

            isComplete = true;
            for(int i=0;i<lst.size();i++){
                if(pointers[i] != lst.get(i).size()){
                    isComplete = false;
                    break;
                }
            }
        }
        System.out.println("ans " + ans);

    }
}
