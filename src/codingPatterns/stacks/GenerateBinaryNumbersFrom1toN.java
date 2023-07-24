package codingPatterns.stacks;

import java.util.ArrayDeque;
import java.util.Queue;

public class GenerateBinaryNumbersFrom1toN {

    public static void main(String[] args) {

        Queue<String> queue = new ArrayDeque<>();
        int n = 1;
        int k = 11;
        queue.add("1");
        while(n <= k){
            String item = queue.poll();
            System.out.println(item);
            queue.add(item + "0");
            queue.add(item + "1");
            n++;
        }



    }
}
