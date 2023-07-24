package bst;

import java.util.ArrayList;
import java.util.List;

/*

         10
        /  \
      7     14
     / \
    3   8
   /\
  2   4
 */
public class KthMaxInBST {
    public static void main(String[] args) {
        BSTN four = new BSTN(null, null, 4);
        BSTN two = new BSTN(null, null, 2);
        BSTN three = new BSTN(two, four, 3);
        BSTN eight = new BSTN(null, null, 8);
        BSTN seven = new BSTN(three, eight, 7);
        BSTN fotn = new BSTN(null, null, 14);
        BSTN ten = new BSTN(seven, fotn, 10);

        int max = getKthMax(ten, 1);
        System.out.println(max);
    }

    private static int getKthMax(BSTN root, int k) {

        List<Integer> lst = new ArrayList<>();

        inorder(root, lst);

        int index = lst.size() - k;
        return lst.get(index);

    }

    private static void inorder(BSTN root, List<Integer> lst) {
        if(root == null){
            return;
        }
        inorder(root.left, lst);
        lst.add(root.val);
        inorder(root.right, lst);
    }


}
