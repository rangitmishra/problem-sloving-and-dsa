package java1.lowlevel;

public class DeadlockImpl extends Thread {

    private Thread main;

    public DeadlockImpl(Thread main){
        this.main = main;
    }

    public void run(){
        System.out.println("Inside child thread..waiting to complete");
        try {
            Thread.sleep(2000);
            main.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("child completed");
    }


    public static void main(String[] args) throws InterruptedException {
        DeadlockImpl child = new DeadlockImpl(Thread.currentThread());
        System.out.println("Main thread started..waiting to complete");
        child.start();
        child.join();
        System.out.println("Main completed");
    }




}
