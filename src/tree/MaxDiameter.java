package tree;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/*

       1
      / \
     2   3
    /\  /\
   4 5 6  7

 */
public class MaxDiameter {

    public static void main(String[] args) {


        Tree four = new Tree(null,4,null);
        Tree five = new Tree(null,5,null);
        Tree six = new Tree(null,6,null);
        Tree seven = new Tree(null,7,null);
        Tree two = new Tree(four,2,five);
        Tree three = new Tree(six,3, seven);
        Tree one = new Tree(two, 1, three);
        AtomicInteger dia = new AtomicInteger(0);
        int ans = getMaxDiameter(one, dia);
        System.out.println(dia.get());

    }

    private static int getMaxDiameter(Tree root, AtomicInteger dia) {
        if(root == null){
            return 0;
        }
        int l = getMaxDiameter(root.left, dia);
        int r = getMaxDiameter(root.right, dia);
        int sum = l + r + 1;
        dia.set(Math.max(sum, dia.get()));
        return Math.max(l, r)+1;
    }

}
