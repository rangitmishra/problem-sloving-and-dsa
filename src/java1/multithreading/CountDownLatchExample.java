package java1.multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(2);
        DevTeam devA = new DevTeam(countDownLatch, "Dev Team A");
        DevTeam devB = new DevTeam(countDownLatch, "Dev Team B");
        devA.start();
        devB.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Now QA team can start");

    }


}

class DevTeam extends Thread {
    private CountDownLatch countDownLatch;
    private String name;

    public DevTeam(CountDownLatch countDownLatch, String name){
        super(name);
        this.countDownLatch = countDownLatch;
    }
    public void run(){
        System.out.println(Thread.currentThread().getName() + " is working");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        countDownLatch.countDown();
    }
}
