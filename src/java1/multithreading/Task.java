package java1.multithreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Task implements Runnable{
    public static AtomicLong atomicInteger = new AtomicLong(0);
    private int start;
    private int end;

    public Task(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public void run() {
        long sum = 0;
        for(int i=start;i<=end; i++){
            sum += i;
        }
        atomicInteger.addAndGet(sum);
    }
}
