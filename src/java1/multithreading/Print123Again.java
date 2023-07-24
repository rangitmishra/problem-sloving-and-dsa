package java1.multithreading;

public class Print123Again {
    int n = 50;
    int counter = 1;
    public synchronized void printNum(int rem){
        while(counter < n){
            while(counter%3 != rem){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName() +"-"+ counter);
            counter++;
            this.notifyAll();
        }
    }

    public static void main(String[] args) {
        Print123Again obj = new Print123Again();
        Thread t1 = new Thread(() -> obj.printNum(1), "T1");
        Thread t2 = new Thread(() -> obj.printNum(2), "T2");
        Thread t3 = new Thread(() -> obj.printNum(0), "T3");
        t1.start();
        t2.start();
        t3.start();
    }
}
