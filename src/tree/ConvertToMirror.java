package tree;

/*

       1
      / \
     2   3
    /\  /\
   4 5 6  7

       1
      / \
     3   2
    /\  /\
   7 6 5  4

 */
public class ConvertToMirror {

    public static void main(String[] args) {

        Tree four = new Tree(null,4,null);
        Tree five = new Tree(null,5,null);
        Tree six = new Tree(null,6,null);
        Tree seven = new Tree(null,7,null);
        Tree two = new Tree(four,2,five);
        Tree three = new Tree(six,3, seven);
        Tree one = new Tree(two, 1, three);


        Tree ans = mirror(one);

        inorder(ans);

    }

    private static void inorder(Tree root) {
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    private static Tree mirror(Tree root) {
        if(root == null){
            return null;
        }

        Tree l = mirror(root.left);
        Tree r = mirror(root.right);
        root.left = r;
        root.right = l;
        return  root;
    }
}
