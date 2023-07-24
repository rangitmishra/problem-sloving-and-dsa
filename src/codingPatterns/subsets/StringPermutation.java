package codingPatterns.subsets;

import java.util.HashSet;
import java.util.Set;

/*
Problem Statement
Given a string, find all of its permutations preserving the character sequence but changing case.
Example 1:
Input: "ad52"
Output: "ad52", "Ad52", "aD52", "AD52"
Example 2:
Input: "ab7c"
Output: "ab7c", "Ab7c", "aB7c", "AB7c", "ab7C", "Ab7C", "aB7C", "AB7C"
 */
public class StringPermutation {

    public static void main(String[] args) {
        String str = "ab7c";
        Set<String> set = new HashSet<>();
        for(int i=0;i<Math.pow(2,str.length());i++){
            int num = i;
            String ans = "";
            for(int j=0;j< str.length();j++){

                int b = num & 1;
                int idx = str.length()-1-j;
                if(b==1){
                    if(Character.isLowerCase(str.charAt(idx))){
                        ans = String.valueOf(str.charAt(idx)).toUpperCase() + ans;
                    }else if(Character.isUpperCase(str.charAt(idx))){
                        ans = String.valueOf(str.charAt(idx)).toLowerCase() + ans;
                    } else {
                        ans = str.charAt(idx) + ans;
                    }
                } else {
                    ans = str.charAt(idx) + ans;
                }

                num = num>>1;

            }
            set.add(ans);
        }

        System.out.println(set);
    }
}
