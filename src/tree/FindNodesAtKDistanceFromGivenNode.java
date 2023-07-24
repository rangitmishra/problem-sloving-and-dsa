package tree;

import java.util.ArrayList;
import java.util.List;

/*
          1
      /      \
     2       3
    / \     / \
   4  5    6   7
 / \ / \  / \  /\
8 9 1011 1213 1415

 */
public class FindNodesAtKDistanceFromGivenNode {

    public static void main(String[] args) {
        Tree n8 = new Tree(null, 8, null);
        Tree n9 = new Tree(null, 9, null);
        Tree n10 = new Tree(null, 10, null);
        Tree n11 = new Tree(null, 11, null);
        Tree n12 = new Tree(null, 12, null);
        Tree n13 = new Tree(null, 13, null);
        Tree n14 = new Tree(null, 14, null);
        Tree n15 = new Tree(null, 15, null);
        Tree n4 = new Tree(n8, 4, n9);
        Tree n5 = new Tree(n10, 5, n11);
        Tree n6 = new Tree(n12, 6, n13);
        Tree n7 = new Tree(n14, 7, n15);
        Tree n2 = new Tree(n4, 2, n5);
        Tree n3 = new Tree(n6, 3, n7);
        Tree n1 = new Tree(n2, 1, n3);
        List<Tree> path = getPathToNode(n1, n6);
        printKDistAway(path, 3);

        //System.out.println(Arrays.toString(path.toArray()));

    }

    private static void printKDistAway(List<Tree> path, int dis) {
        Tree prevNode = null;
        for(int i=0;i<path.size();i++){
            printKLevelDown(path.get(i),dis-i, prevNode);
            prevNode = path.get(i);
        }
    }

    private static List<Tree> getPathToNode(Tree root, Tree node) {
        if(root == null){
            return null;
        }
        if(root == node){
            List<Tree> lst = new ArrayList<>();
            lst.add(root);
            return lst;
        }
        List<Tree> leftContains = getPathToNode(root.left, node);
        if(leftContains != null){
            leftContains.add(root);
            return leftContains;
        }

        List<Tree> rightContains = getPathToNode(root.right, node);
        if(rightContains != null){
            rightContains.add(root);
            return rightContains;
        }

        return null;

    }

    private static void printKLevelDown(Tree root, int k, Tree block) {
        if(root == null){
            return;
        }
        if(root == block){
            return;
        }
        if(k == 0){
            System.out.println(root.val);
            return;
        }
        printKLevelDown(root.left, k-1, block);
        printKLevelDown(root.right, k-1, block);
    }


}
