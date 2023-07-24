package codingPatterns.twoHeap;

import java.util.Collections;
import java.util.PriorityQueue;

/*
Problem Statement
Design a class to calculate the median of a number stream. The class should have the following two methods:
insertNum(int num): stores the number in the class
findMedian(): returns the median of all numbers inserted in the class
If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.
Example 1:
1. insertNum(3)
2. insertNum(1)
3. findMedian() -> output: 2
4. insertNum(5)
5. findMedian() -> output: 3
6. insertNum(4)
7. findMedian() -> output: 3.5
 */
public class MedianOfStream {


    public static void main(String[] args) {
        int[] arr = {3,1,5,4,7,8};
        PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> greater = new PriorityQueue<>();
        double median = arr[0];
        smaller.add(arr[0]);

        for(int i=1;i<arr.length;i++) {
            int x = arr[i];

            if(smaller.size() == greater.size()){
                if(x > median){
                    greater.add(x);
                    median = greater.peek();
                } else {
                    smaller.add(x);
                    median = smaller.peek();
                }

            } else if( smaller.size() > greater.size()) {
                if(x > median) {
                    greater.add(x);
                } else {
                    greater.add(smaller.poll());
                    smaller.add(x);
                }
                median = (greater.peek() + smaller.peek())/2.0;

            } else {
                if(x > median) {
                    smaller.add(greater.poll());
                    greater.add(x);
                } else {
                    smaller.add(x);
                }
                median = (greater.peek() + smaller.peek())/2.0;

            }
            System.out.println(median);
        }

    }
}
