package java1.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TokenBucketUsingThreadDemo {

    public static void main(String[] args) throws InterruptedException {

        TokenBucketUsingThread tokenBucketUsingThread = new TokenBucketUsingThread(5, 3);
        Thread.sleep(2000);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=0;i<16;i++){
            executorService.execute(tokenBucketUsingThread::getToken);
        }
    }
}
