package bst;

/*

       20
      /  \
     10  25
    / \  / \
   8 11 23  28


 */
public class KthLargestINBST {
    public static void main(String[] args) {
        BSTN et = new BSTN(null, null, 8);
        BSTN lvn = new BSTN(null, null, 11);
        BSTN t3 = new BSTN(null, null, 23);
        BSTN t8 = new BSTN(null, null, 28);
        BSTN tn = new BSTN(et, lvn, 10);
        BSTN t5 = new BSTN(t3, t8, 25);
        BSTN t0 = new BSTN(tn, t5, 20);

        int k = 7;

/*
        int ans = getKthMin(t0, k);
        System.out.println(ans);
*/

        System.out.println("======KTH MAX========");
        System.out.println(getKthMax(t0, k));
    }

    private static int getKthMax(BSTN root, int k) {

        if(root == null){
            return 0;
        }

        while(root != null){
            if(root.right == null){
                k--;
                if(k==0){
                    return root.val;
                }
                root = root.left;
            } else {

                BSTN curr = root.right;
                while(curr.left != null && curr.left != root){
                    curr = curr.left;
                }
                if(curr.left == null){
                    curr.left = root;
                    root = root.right;
                } else {
                    k--;
                    if(k ==0){
                        return root.val;
                    }
                    curr.left = null;
                    root = root.left;
                }
            }
        }
        return 0;

    }

    private static int getKthMin(BSTN root, int k) {

        if(root == null){
            return 0;
        }

        while(root != null){
            if(root.left == null){
                k--;
                if(k==0){
                    return root.val;
                }
                root = root.right;
            } else {

                BSTN curr = root.left;
                while(curr.right != null && curr.right != root){
                    curr = curr.right;
                }
                if(curr.right == null){
                    curr.right = root;
                    root = root.left;
                } else {
                    k--;
                    if(k ==0){
                        return root.val;
                    }
                    curr.right = null;
                    root = root.right;
                }
            }
        }
        return 0;
    }

}
