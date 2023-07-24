package codingPatterns.fastNSlowPointer;

/*
Problem Statement
Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.
If the total number of nodes in the LinkedList is even, return the second middle node.
Example 1:
Input: 1 -> 2 -> 3 -> 4 -> 5 -> null
Output: 3
Example 2:
Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
Output: 4
Example 3:
Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
Output: 4
 */
public class MiddleOfLL {

    static class LLNode {
        public int n;
        public LLNode next;

        public LLNode(int n, LLNode next){
            this.n = n;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LLNode seven = new LLNode(7, null);
        LLNode six = new LLNode(6, seven);
        LLNode five = new LLNode(5, six);
        LLNode four = new LLNode(4, five);
        LLNode three = new LLNode(3, four);
        LLNode two = new LLNode(2, three);
        LLNode head = new LLNode(1, two);

        LLNode fast = head;
        LLNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println(slow.n);

    }
}
