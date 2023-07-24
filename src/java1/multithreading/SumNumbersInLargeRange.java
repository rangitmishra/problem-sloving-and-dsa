package java1.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
sum numbers from 1 to 100 Million
 */
public class SumNumbersInLargeRange extends Thread{

    public void run(){

    }

    public static void main(String[] args) {

       /* int n = 100000000;
        System.out.println("Parallel Approach");
        long start = System.currentTimeMillis();
        //long sum = getSequentialSum(n);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int st = 0;
        int incr = n/10;
        for(int i=0;i<10;i++){
            int en = st + incr;
            executorService.submit(new Task(st+1, en));
            st = en;
        }
        long end = System.currentTimeMillis();
        System.out.println("Sum = " + Task.atomicInteger + " Time Taken:" + (end-start));*/


        int n = 100000000;
        System.out.println("Sequential Approach");
        long start = System.currentTimeMillis();
        long sum = getSequentialSum(n);
        long end = System.currentTimeMillis();
        System.out.println("Sum = " + sum+ " Time Taken:" + (end-start));


    }

    private static long getSequentialSum(int n) {
        long sum = 0;
        for(int i=1;i<=n;i++){
            sum += i;
        }
        return sum;
    }


}
