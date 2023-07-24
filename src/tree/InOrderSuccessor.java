package tree;

public class InOrderSuccessor {

    public static class STree {
        int val;
        STree left;
        STree right;
        STree next;

        public STree(STree left, int val, STree right){
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        STree seven = new STree(null, 7, null);
        STree eight = new STree(null, 8, null);
        STree six = new STree(null, 6, null);
        STree four = new STree(null, 4, null);
        STree five = new STree(seven, 5, eight);
        STree three = new STree(five, 3, six);
        STree two = new STree(four, 2, null);
        STree one = new STree(two, 1, three);


        pointInorderSuccessor(one, null);

    }

    private static void pointInorderSuccessor(STree root, STree prev) {
        //1
        if(root == null){
            return;
        }

        //2
        pointInorderSuccessor(root.left, prev);

        //3
        if(prev != null){
            prev.next = root;
        }
        prev = root;

        //4
        pointInorderSuccessor(root.right, prev);

    }
}
