package bst;

import java.util.List;

/*

https://www.youtube.com/watch?v=sWf7k1x9XR4
       1
      / \
     2   3
   / \
  4  5
      \
       6

 */
public class FlattenBTreeToLL {
    static BSTN prev = null;

    public static void main(String[] args) {
        BSTN four = new BSTN(null, null, 4);
        BSTN six = new BSTN(null, null, 6);
        BSTN five = new BSTN(null, six, 5);
        BSTN two = new BSTN(four, five, 2);
        BSTN three = new BSTN(null, null, 3);
        BSTN one = new BSTN(two, three, 1);

        flattenTreeToLL(one);

        while(one != null){
            System.out.println(one.val);
            one = one.right;
        }
    }

    private static void flattenTreeToLL(BSTN root) {

        if(root == null){
            return;
        }
        flattenTreeToLL(root.right);
        flattenTreeToLL(root.left);

        root.right = prev;
        root.left =  null;
        prev = root;
    }
}
