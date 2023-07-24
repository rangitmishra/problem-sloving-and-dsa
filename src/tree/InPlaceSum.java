package tree;

/*

       1
      / \
     2   3
    /\  /\
   4 5 6  7

 */
public class InPlaceSum {

    public static void main(String[] args) {

        Tree four = new Tree(null,4,null);
        Tree five = new Tree(null,5,null);
        Tree six = new Tree(null,6,null);
        Tree seven = new Tree(null,7,null);
        Tree two = new Tree(four,2,five);
        Tree three = new Tree(six,3, seven);
        Tree one = new Tree(two, 1, three);

        preorder(one);
        inPlaceSum(one);
        System.out.println("--------------");
        preorder(one);



    }

    private static void preorder(Tree one) {
        if(one == null){
            return;
        }
        System.out.println(one.val);
        preorder(one.left);
        preorder(one.right);
    }

    private static int inPlaceSum(Tree one) {

        if(one == null){
            return 0;
        }

        int l = inPlaceSum(one.left);
        int r =inPlaceSum(one.right);

        int sum= one.val + l + r;
        one.val = l + r;
        return sum;
    }
}
