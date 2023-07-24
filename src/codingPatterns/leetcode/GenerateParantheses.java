package codingPatterns.leetcode;
/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
 */
public class GenerateParantheses {

    public static void main(String[] args) {

        generateParantheses(3, 0, 0, "");
    }

    private static void generateParantheses(int n, int open, int close, String ans) {

        if(close == n){
            System.out.println(ans);
            return;
        }

        if(open < n){
            generateParantheses(n, open+1, close, ans + "{");
        }
        if(open > close){
            generateParantheses(n, open, close+1, ans + "}");
        }


    }
}
