package tree;

import java.util.LinkedList;

/*

       1
      / \
     2   3
    /\  /\
   4 5 6  7

 */
public class ReverseLevelTraversal {
    public static void main(String[] args) {
        Tree four = new Tree(null,4,null);
        Tree five = new Tree(null,5,null);
        Tree six = new Tree(null,6,null);
        Tree seven = new Tree(null,7,null);
        Tree two = new Tree(four,2,five);
        Tree three = new Tree(six,3, seven);
        Tree one = new Tree(two, 1, three);

        LinkedList<Integer> ans = new LinkedList<>();
        LinkedList<Tree> lst = new LinkedList<>();

        lst.addLast(one);
        ans.addFirst(one.val);

        while(!lst.isEmpty()) {
            Tree item = lst.pollLast();
            if(item.right != null){
                lst.addFirst(item.right);
                ans.addFirst(item.right.val);
            }
            if(item.left != null){
                lst.addFirst(item.left);
                ans.addFirst(item.left.val);
            }
        }

        while(!ans.isEmpty()) {
            System.out.println(ans.pollFirst());
        }


    }
}
