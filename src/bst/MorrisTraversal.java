package bst;

/*
https://www.youtube.com/watch?v=80Zug6D1_r4
Morris Traversal
T = O(n)
S = O(1)
---------
Recursion
T = O(n)
S = O(n) - stack call


       1
      / \
     2   3
   / \
  4  5
      \
       6

 */

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {

    public static void main(String[] args) {
        BSTN four = new BSTN(null, null, 4);
        BSTN six = new BSTN(null, null, 6);
        BSTN five = new BSTN(null, six, 5);
        BSTN two = new BSTN(four, five, 2);
        BSTN three = new BSTN(null, null, 3);
        BSTN one = new BSTN(two, three, 1);

        List<Integer> inorder = inorderMorrisTraversal(one);
        System.out.println(inorder);
    }

    private static List<Integer> inorderMorrisTraversal(BSTN root) {
        List<Integer> inorder = new ArrayList<>();
        BSTN curr = root;
        while (curr != null){
            if(curr.left == null){
                inorder.add(curr.val);
                curr = curr.right;
            } else {
                BSTN rmNode = curr.left;
                while(rmNode.right != null && rmNode.right != curr){
                    rmNode = rmNode.right;
                }
                if(rmNode.right == null){
                    rmNode.right = curr;
                    curr = curr.left;
                } else {
                    rmNode.right = null;
                    inorder.add(curr.val);
                    curr = curr.right;
                }

            }
        }

        return inorder;
    }
}
