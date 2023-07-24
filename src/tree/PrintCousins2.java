package tree;

import java.util.LinkedList;
import java.util.Queue;

/*

    1
   / \
  2   3
 / \ / \
6  7 4  5

 */
// Wrong Implementation
public class PrintCousins2 {

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(Node left, int val, Node right) {
            this.left = left;
            this.val = val;
            this.right= right;
        }
    }

    public static void main(String[] args) {

        Node n6 = new Node(null, 6, null);
        Node n7 = new Node(null, 7, null);
        Node n4 = new Node(null, 4, null);
        Node n5 = new Node(null, 5, null);

        Node n2 = new Node(n6, 2, n7);
        Node n3 = new Node(n4, 3, n5);

        Node root = new Node(n2, 1, n3);

        printCousins(root, n7);




    }

    private static void printCousins(Node root, Node find) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        boolean startPrintingCousin = false;
        while(!queue.isEmpty()) {
            int n = queue.size();

            while(n > 0){
                Node p = queue.poll();
                if(startPrintingCousin){
                    if(p.left != null){
                        System.out.println(p.left.val);
                    }
                    if(p.right != null){
                        System.out.println(p.right.val);
                    }

                } else {
                    if((p.left != null && p.left == find)||(p.right != null && p.right == find)) {
                        startPrintingCousin = true;
                    }
                    if(p.left != null){
                        queue.add(p.left);
                    }
                    if(p.right != null){
                        queue.add(p.right);
                    }
                }
                n--;
            }
            if(startPrintingCousin){
                break;
            }
        }
    }
}
