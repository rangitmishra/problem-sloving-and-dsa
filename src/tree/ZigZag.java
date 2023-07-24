package tree;


import java.util.LinkedList;

/*

       1
      / \
     2   3
    /\  /\
   4 5 6  7

 */
public class ZigZag {

    public static void main(String[] args) {
        Tree four = new Tree(null,4,null);
        Tree five = new Tree(null,5,null);
        Tree six = new Tree(null,6,null);
        Tree seven = new Tree(null,7,null);
        Tree two = new Tree(four,2,five);
        Tree three = new Tree(six,3, seven);
        Tree one = new Tree(two, 1, three);

        LinkedList<Tree> lst = new LinkedList<>();
        lst.add(one);
        boolean flag = false;

        while(!lst.isEmpty()) {

            int cnt = lst.size();
            while(cnt-- > 0){
                if(flag){
                    Tree item = lst.pollLast();
                    System.out.println(item.val);

                    if(item.right != null){
                        lst.addFirst(item.right);
                    }
                    if(item.left != null){
                        lst.addFirst(item.left);
                    }

                } else {
                    Tree item = lst.pollFirst();
                    System.out.println(item.val);

                    if(item.left != null){
                        lst.addLast(item.left);
                    }
                    if(item.right != null){
                        lst.addLast(item.right);
                    }

                }

            }
            flag = !flag;


        }
    }
}
