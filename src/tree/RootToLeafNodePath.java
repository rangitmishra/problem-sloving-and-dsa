package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*

       1
      / \
     2   3
    /\  /\
   4 5 6  7
  /\
 8 9
 */
public class RootToLeafNodePath {
    public static void main(String[] args) {
        Tree eight = new Tree(null,8,null);
        Tree nine = new Tree(null,9,null);
        Tree four = new Tree(eight,4,nine);
        Tree five = new Tree(null,5,null);
        Tree six = new Tree(null,6,null);
        Tree seven = new Tree(null,7,null);
        Tree two = new Tree(four,2,five);
        Tree three = new Tree(six,3, seven);
        Tree one = new Tree(two, 1, three);

        //printPathStr(one, "");

        LinkedList<Integer> lst = new LinkedList<>();
        printPathLst(one, lst);

    }

    private static void printPathLst(Tree root, LinkedList<Integer> lst) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            lst.addLast(root.val);
            System.out.println(lst.toString());
            lst.removeLast();
        }
        lst.addLast(root.val);
        printPathLst(root.left, lst);
        printPathLst(root.right, lst);
        lst.removeLast();
    }

    private static void printPathStr(Tree root, String path) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            System.out.println(path + root.val);
        }
        printPathStr(root.left, path + root.val);
        printPathStr(root.right, path+ root.val);
    }
}
