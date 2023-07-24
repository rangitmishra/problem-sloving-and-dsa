package tree;

import java.util.concurrent.atomic.AtomicInteger;

/*
        1
      /  \
     2    3
     \   / \
     -4  5  6
        /\
       7 8

 */
public class MaxSumPath {
    public static void main(String[] args) {
        Tree seven = new Tree(null,7,null);
        Tree eight = new Tree(null,8,null);
        Tree four = new Tree(null,-4,null);
        Tree six = new Tree(null,6,null);
        Tree two = new Tree(null,2,four);
        Tree five = new Tree(seven,5, eight);
        Tree three = new Tree(five, 3, six);
        Tree one = new Tree(two, 1, three);

        AtomicInteger num = new AtomicInteger(0);
        int ans = maxSum(one, num);
        System.out.println(num.get());

    }

    private static int maxSum(Tree root, AtomicInteger num) {
        if(root == null){
            return 0;
        }
        int l = maxSum(root.left, num);
        int r = maxSum(root.right, num);
        num.set(Math.max(l+r+root.val, num.get()));
        return Math.max(l,r) + root.val;

    }
}
