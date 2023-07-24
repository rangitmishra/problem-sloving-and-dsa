package tree;

import java.util.*;

/*
       1
      / \
     2   3
    /\  /\
   4 5 6  7
 */
public class TreeView {
    public static class Node {
        int height;
        int val;
        public Node(int height, int val){
            this.height = height;
            this.val = val;
        }

    }

    public static class Pair {
        int hd;
        Tree tree;

        public Pair(int hd, Tree tree){
            this.hd = hd;
            this.tree = tree;
        }
    }

    public static void main(String[] args) {

        Tree ten = new Tree(null, 10, null);
        Tree nine = new Tree(ten, 9, null);
        Tree eight = new Tree(nine, 8, null);

        Tree four = new Tree(null, 4, null);
        Tree five = new Tree(eight, 5, null);
        Tree six = new Tree(null, 6, null);
        Tree seven = new Tree(null, 7, null);
        Tree two = new Tree(four, 2, five);
        Tree three = new Tree(six, 3, seven);
        Tree one = new Tree(two, 1, three);

      /*  topView(one);
        System.out.println("-----Level order------");
        topViewLevel(one);

        System.out.println("-----Bottom View--------");
        bottomView(one);
*/
        System.out.println("------Left View--------");
        Set<Integer> visited = new HashSet<>();
        leftView(one, visited, 0);

        System.out.println("------Right View--------");
        Set<Integer> rvisited = new HashSet<>();
        rightView(one, rvisited, 0);


    }

    private static void leftView(Tree one, Set<Integer> visited, int ht) {
        if(one == null){
            return;
        }
        if(!visited.contains(ht)){
            System.out.println(one.val);
            visited.add(ht);
        }
        leftView(one.left, visited, ht+1);
        leftView(one.right, visited, ht+1);

    }

    private static void rightView(Tree one, Set<Integer> visited, int ht) {
        if(one == null){
            return;
        }
        if(!visited.contains(ht)){
            System.out.println(one.val);
            visited.add(ht);
        }
        rightView(one.right, visited, ht+1);
        rightView(one.left, visited, ht+1);

    }

    private static void bottomView(Tree one) {

        if(one == null){
            return;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        LinkedList<Pair> queue = new LinkedList<>();
        Pair p = new Pair(0, one);
        queue.addLast(p);

        while(!queue.isEmpty()){
            Pair item = queue.poll();
            map.put(item.hd, item.tree.val);
            if(item.tree.left != null){
                queue.addLast(new Pair(item.hd-1, item.tree.left));
            }
            if(item.tree.right != null){
                queue.addLast(new Pair(item.hd+1, item.tree.right));
            }
        }

        for(Map.Entry<Integer, Integer> n : map.entrySet()){
            System.out.println(n.getValue());
        }
    }

    private static void topViewLevel(Tree one) {
        if(one == null){
            return;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        LinkedList<Pair> queue = new LinkedList<>();
        Pair p = new Pair(0, one);
        queue.add(p);
        while(!queue.isEmpty()){
            Pair item = queue.poll();
            map.putIfAbsent(item.hd, item.tree.val);
            if(item.tree.left != null){
                queue.addLast(new Pair(item.hd-1, item.tree.left));
            }
            if(item.tree.right != null){
                queue.addLast(new Pair(item.hd+1, item.tree.right));
            }
        }

        for(Map.Entry<Integer, Integer> n : map.entrySet()){
            System.out.println(n.getValue());
        }

    }

    private static void topView(Tree one) {
        Map<Integer, Node> map = new TreeMap<>();
        topV(one, map, 0, 0);
        for(Map.Entry<Integer, Node> n : map.entrySet()){
            System.out.println(n.getValue().val);
        }
    }

    private static void topV(Tree one, Map<Integer, Node> map, int ht, int hd) {
        if(one == null){
            return;
        }
        topV(one.left, map, ht+1, hd-1);
        if(map.containsKey(hd)){
            if(map.get(hd).height >= ht){
                map.put(hd, new Node(ht, one.val));
            }

        } else {
            map.put(hd, new Node(ht, one.val));
        }
        topV(one.right, map, ht+1, hd+1);
    }
}
