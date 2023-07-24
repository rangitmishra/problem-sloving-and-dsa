package java1.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/*
There is a room inside which at one time only 3 people can enter
 */
public class SemaphoreExample {

    private Semaphore semaphore = new Semaphore(3);

    public void enterInside(int idx){
        try {
            semaphore.acquire();
            System.out.println(idx + " is inside the room");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
        System.out.println("waiting.......");
    }


    public static void main(String[] args) {
        SemaphoreExample semaphoreExample = new SemaphoreExample();
        ExecutorService ex = Executors.newFixedThreadPool(10);
        for(int i=0;i<12;i++){
            int name = i;
            ex.execute(() -> semaphoreExample.enterInside(name));
        }
    }
}
