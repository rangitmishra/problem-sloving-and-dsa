package java1.multithreading;

import java.util.concurrent.Semaphore;

public class UnisexBathroomProblem {

    private int maxCount;
    private Semaphore male;
    private Semaphore female;


    public void maleEnter(){
        try {
            male.acquire();
            System.out.println("Male Entered");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        male.release();
    }

    public void femaleEnter(){

    }
}
