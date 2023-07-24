package bst;

/*

         10
        /  \
      7     14
     / \
    3   8
   /\
  2   4
 */
public class MinimumInBST {

    public static void main(String[] args) {

        BSTN four = new BSTN(null, null, 4);
        BSTN two = new BSTN(null, null, 2);
        BSTN three = new BSTN(two, four, 3);
        BSTN eight = new BSTN(null, null, 8);
        BSTN seven = new BSTN(three, eight, 7);
        BSTN fotn = new BSTN(null, null, 14);
        BSTN ten = new BSTN(seven, fotn, 10);

        int minVal = getMin(ten);
        System.out.println(minVal);
    }

    private static int getMin(BSTN root) {
        if(root == null){
            return -1;
        }
        if(root.left == null){
            return root.val;
        }

        return getMin(root.left);
    }


}
