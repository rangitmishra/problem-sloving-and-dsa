package tree;

/*

       1
      / \
     2   3
    /\  /\
   4 5 6  7

 */
public class LCA {
    public static void main(String[] args) {


        Tree four = new Tree(null,4,null);
        Tree five = new Tree(null,5,null);
        Tree six = new Tree(null,6,null);
        Tree seven = new Tree(null,7,null);
        Tree two = new Tree(four,2,five);
        Tree three = new Tree(six,3, seven);
        Tree one = new Tree(two, 1, three);

        Tree ans = getLCA(one, seven, six);
        System.out.println(ans.val);

    }

    private static Tree getLCA(Tree root, Tree node1, Tree node2) {

        if(root == null){
            return null;
        }

        if(root==node1 || root == node2){
            return root;
        }

        Tree l = getLCA(root.left, node1, node2);
        Tree r = getLCA(root.right, node1, node2);
        if(l != null && r!= null){
            return root;
        }
        if(l != null){
            return l;
        }
        if(r != null){
            return r;
        }

        return null;
    }
}
