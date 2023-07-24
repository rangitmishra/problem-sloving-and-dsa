package bst;

public class BSTN {
    public BSTN left;
    public BSTN right;
    public int val;
    public BSTN(BSTN left, BSTN right, int val){
        this.left = left;
        this.right = right;
        this.val = val;
    }
}
