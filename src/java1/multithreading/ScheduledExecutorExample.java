package java1.multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorExample {


    public static void main(String[] args) {


        ScheduledExecutorService ex = Executors.newScheduledThreadPool(10);
        //ex.schedule(()-> System.out.println("Ting Ting"), 10, TimeUnit.SECONDS);

        //ex.scheduleAtFixedRate(()-> System.out.println("Ting Ting"), 2, 3, TimeUnit.SECONDS);
        ex.scheduleWithFixedDelay(()-> System.out.println("Ting Ting"), 2, 3, TimeUnit.SECONDS);




    }
}
