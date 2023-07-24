package java1.multithreading;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        PassengerThread ps1 = new PassengerThread(cyclicBarrier, "Passenger 1");
        PassengerThread ps4 = new PassengerThread(cyclicBarrier, "Passenger 4");
        ps1.start();
        ps4.start();

        Thread.sleep(4000);

        PassengerThread ps2 = new PassengerThread(cyclicBarrier, "Passenger 2");
        PassengerThread ps3 = new PassengerThread(cyclicBarrier, "Passenger 3");
        ps2.start();
        ps3.start();

    }


}

class PassengerThread extends Thread {
    private CyclicBarrier cyclicBarrier;
    private String name;

    public PassengerThread(CyclicBarrier cyclicBarrier, String name){
        super(name);
        this.cyclicBarrier = cyclicBarrier;
    }
    public void run(){
        System.out.println(Thread.currentThread().getName() + " has arrived, waiting for more");
        try {
            Thread.sleep(1000);
            int count = cyclicBarrier.await();
            if(count == 0){
                System.out.println("All has arrived so lets move now");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}