package tree;

/*

       1
      / \
     2   3
    /\  /\
   4 5 6  7

 */

public class InorderTraversal {

    public static void main(String[] args) {
        Tree four = new Tree(null,4,null);
        Tree five = new Tree(null,5,null);
        Tree six = new Tree(null,6,null);
        Tree seven = new Tree(null,7,null);
        Tree two = new Tree(four,2,five);
        Tree three = new Tree(six,3, seven);
        Tree one = new Tree(two, 1, three);

        System.out.println("Inorder");
        inorder(one);
        System.out.println("Pre-order");
        preorder(one);
        System.out.println("Post-order");
        postorder(one);

    }

    private static void postorder(Tree one) {
        if(one == null){
            return;
        }

        postorder(one.left);
        postorder(one.right);
        System.out.println(one.val);
    }

    private static void preorder(Tree one) {
        if(one == null){
            return;
        }
        System.out.println(one.val);
        preorder(one.left);
        preorder(one.right);

    }

    private static void inorder(Tree one) {
        if(one == null){
            return;
        }
        inorder(one.left);
        System.out.println(one.val);
        inorder(one.right);
    }
}
