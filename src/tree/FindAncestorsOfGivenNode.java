package tree;

/*

    1
   / \
  2   3
 / \ / \
6  7 4  5

Find common ancestor of 6, 7 --> 2
 */
public class FindAncestorsOfGivenNode {

    static Tree LCA = null;

    public static void main(String[] args) {

        Tree six = new Tree(null, 6, null);
        Tree sevn = new Tree(null, 7, null);
        Tree fo4 = new Tree(null, 4, null);
        Tree fi5 = new Tree(null, 5, null);
        Tree t2 = new Tree(six, 2, sevn);
        Tree t3 = new Tree(fo4, 3, fi5);
        Tree t1 = new Tree(t2, 1, t3);

        Tree lca = getLCA(fo4, sevn, t1);
        System.out.println(LCA.val);
    }

    private static Tree getLCA(Tree node1, Tree node2, Tree root) {
        if(root == null){
            return null;
        }
        if(root == node1){
            return node1;
        }
        if(root == node2){
            return node2;
        }

        Tree left = getLCA(node1, node2, root.left);
        Tree right = getLCA(node1, node2, root.right);
        if(left != null && right != null){
            LCA = root;
            return root;
        }
        return left == null ? right : left;
    }


}
