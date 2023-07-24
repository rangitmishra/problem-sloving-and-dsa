package java1.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/*

if front door opens - N people can enter
close back door - if all people have vacated
again open front door - N people can enter

 */
public class RestaurantProblem {

    List<String> persons = new ArrayList<>();
    int count = 0;

    Semaphore semaphore = new Semaphore(5);

    CyclicBarrier cyclicBarrier = new CyclicBarrier(5);


    private void closeDoor(){
        performEatingTask();
    }

    private void performEatingTask() {
        try {
            System.out.println("People are eating: " + persons);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Back door opened");
        persons.clear();
        count = 0;
        semaphore.release(5);

    }

    public void enter( String name){
        try {
            semaphore.acquire();
            System.out.println("Entering " + name);
            persons.add(name);
            count++;
            if(count==5){
                closeDoor();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void enter2( String name){
        try {
            try {
                int cnt = cyclicBarrier.await();
                if(cnt ==0){
                    System.out.println("Eating finished" + name);
                    Thread.sleep(1000);
                    System.out.println("Exit the restaurant" + name);
                }
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }



    public static void main(String[] args) {
        RestaurantProblem restaurantProblem = new RestaurantProblem();
        for(int i=0;i<20;i++){
            final String name = "Name " + i;
            Thread t1 = new Thread(() -> {
                restaurantProblem.enter(name);
            });
            t1.start();
        }

    }
}
