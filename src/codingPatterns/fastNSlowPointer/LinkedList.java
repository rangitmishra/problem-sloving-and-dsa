package codingPatterns.fastNSlowPointer;

/*
Problem Statement
Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.
 */
public class LinkedList {

    static class LLNode {
        public int n;
        public MiddleOfLL.LLNode next;

        public LLNode(int n, MiddleOfLL.LLNode next){
            this.n = n;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MiddleOfLL.LLNode seven = new MiddleOfLL.LLNode(7, null);
        MiddleOfLL.LLNode six = new MiddleOfLL.LLNode(6, seven);
        MiddleOfLL.LLNode five = new MiddleOfLL.LLNode(5, six);
        MiddleOfLL.LLNode four = new MiddleOfLL.LLNode(4, five);
        MiddleOfLL.LLNode three = new MiddleOfLL.LLNode(3, four);
        MiddleOfLL.LLNode two = new MiddleOfLL.LLNode(2, three);
        MiddleOfLL.LLNode head = new MiddleOfLL.LLNode(1, two);
        seven.next = six;

        MiddleOfLL.LLNode fast = head;
        MiddleOfLL.LLNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                System.out.println("Yes loop exists");
                break;
            }
        }

    }
}
