package java1.multithreading;

public class Print123 {

    volatile int count = 1;

    public synchronized void print( int remainder){
        while(count < 50){
            while(count % 3 != remainder){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if(remainder == 0){
                System.out.println(Thread.currentThread().getName() + "--" + 3);
            } else {
                System.out.println(Thread.currentThread().getName() + "--" + remainder);
            }

            count++;
            this.notifyAll();
        }
    }

    public static void main(String[] args) {
        Print123 print123 = new Print123();
        Thread t1 = new Thread(() -> {
            print123.print(1);
        }, "T1");
        Thread t2 = new Thread(() -> {
            print123.print(2);
        }, "T2");
        Thread t3 = new Thread(() -> {
            print123.print(0);
        }, "T3");

        t1.start();
        t2.start();
        t3.start();
    }

}
