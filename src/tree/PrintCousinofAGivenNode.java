package tree;

/*

       1
      / \
     2   3
    /\  /\
   4 5 6  7

 */
public class PrintCousinofAGivenNode {

    public static class Pair{
        Tree parent;
        Tree child;

        public Pair(Tree parent, Tree child){
            this.parent = parent;
            this.child = child;
        }

    }
    public static void main(String[] args) {

        Tree four = new Tree(null,4,null);
        Tree five = new Tree(null,5,null);
        Tree six = new Tree(null,6,null);
        Tree seven = new Tree(null,7,null);
        Tree two = new Tree(four,2,five);
        Tree three = new Tree(six,3, seven);
        Tree one = new Tree(two, 1, three);

        printCousin(one, four);

    }

    private static void printCousin(Tree root, Tree node) {

        int level = getLevel(root, node, 1);
        System.out.println("level - " + level);
        printLevel(root, node, level);


    }

    private static void printLevel(Tree root, Tree node, int level) {
        if(level == 0 || level == 1){
            return;
        }

        if(level == 2){
            if(root.left == node || root.right == node){
                return;
            }
            if(root.left != null){
                System.out.println(root.left.val);
            }
            if(root.right != null){
                System.out.println(root.right.val);
            }
        }

        if(level > 2) {
            printLevel(root.left, node, level-1);
            printLevel(root.right, node, level-1);
        }

    }

    private static int getLevel(Tree root, Tree node, int level) {
        if(root == null){
            return 0;
        }
        if(root == node){
            return level;
        }

        int dlevel = getLevel(root.left, node, level+1);
        if(dlevel==0){
            dlevel = getLevel(root.right, node, level+1);
        }
        return dlevel;
    }
}
