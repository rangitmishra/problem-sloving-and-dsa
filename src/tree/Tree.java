package tree;

public class Tree {
    public int val;
    public Tree left;
    public Tree right;
    public Tree(Tree left, int val, Tree right){
        this.left = left;
        this.val = val;
        this.right = right;
    }
}
