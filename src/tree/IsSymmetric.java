package tree;

import java.util.*;

/*

       1
      / \
     2   3
    /\  /\
   4 5 6  7

 */
public class IsSymmetric {
    public static void main(String[] args) {
        //Tree eight = new Tree(null,8,null);
        Tree four = new Tree(null,4,null);
        Tree five = new Tree(null,5,null);
        Tree six = new Tree(null,6,null);
        Tree seven = new Tree(null,7,null);
        Tree two = new Tree(four,2,five);
        Tree three = new Tree(six,3, seven);
        Tree one = new Tree(two, 1, three);

        //boolean ans = isSymmetric(one);
        //System.out.println(ans);


    }

    private static boolean isSymmetric(Tree root) {

        if(root == null){
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(Tree node1, Tree node2) {
        if(node1 == null && node2 == null){
            return true;
        }
        return (node1 != null && node2 != null ) && isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);

    }
}
