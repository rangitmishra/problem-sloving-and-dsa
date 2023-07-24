package java1.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TokenBucketDemo {

    public static void main(String[] args) throws InterruptedException {


        TokenBucket tokenBucket = new TokenBucket(3, 2);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Thread.sleep(4000);

        for(int i=0;i<15;i++){
            executorService.execute(tokenBucket::getToken);
        }
    }
}
