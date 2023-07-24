package codingPatterns.dfs;

import tree.Tree;
import tree.TreeView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Problem Statement
Given a binary tree and a number ‘S’,
find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.

       1
      / \
     2   3
    /\  /\
   4 5 3  1
      /  / \
     1  2  3

 */
public class AllPathsForASum {
    public static int target = 7;
    public static class Node {
        int height;
        int val;
        public Node(int height, int val){
            this.height = height;
            this.val = val;
        }

    }

    public static void main(String[] args) {

        Tree n1 = new Tree(null, 1, null);
        Tree n2 = new Tree(null, 2, null);
        Tree n3 = new Tree(null, 3, null);
        Tree f4 = new Tree(null, 4, null);
        Tree f5 = new Tree(null, 5, null);

        Tree t3 = new Tree(n1, 3, null);
        Tree s1 = new Tree(n2, 1, n3);

        Tree two = new Tree(f4, 2, f5);
        Tree tt3 = new Tree(t3, 3, s1);

        Tree one = new Tree(two, 1, tt3);

        LinkedList<Integer> path = new LinkedList<>();
        printPath(one, path, 0);


        System.out.println("----------");
        path.clear();
        printPathToleaf(one, path, 0);

    }

    private static void printPathToleaf(Tree root, LinkedList<Integer> path, int sum) {

        if(root == null){
            return;
        }
        sum = sum + root.val;
        path.addLast(root.val);
        if(root.left == null && root.right == null && sum == target){
            System.out.println(path.toString());
        } else if(sum < target){
            printPathToleaf(root.left, path, sum);
            printPathToleaf(root.right, path, sum);
        }
        path.removeLast();
    }

    private static void printPath(Tree root, LinkedList<Integer> path, int sum) {

        if(root == null){
            return;
        }
        path.addLast(root.val);
        sum = sum + root.val;
        if(sum == target){
            System.out.println(path.toString());
        } else if(sum < target) {
            printPath(root.left, path, sum);
            printPath(root.right, path, sum);
        }

        path.removeLast();

    }
}
