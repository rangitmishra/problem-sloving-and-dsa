package java1.multithreading;

import java.util.ArrayDeque;
import java.util.Queue;

public class ProducerConsumer {

    int size = 10;
    Queue<Integer> queue = new ArrayDeque<>(size);


    public synchronized void produce(int n){
        while(queue.size() == size){
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Produced " + n);
        queue.add(n);
        this.notifyAll();
    }


    public synchronized void consume(){
        while(queue.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Consumed "+ queue.poll());
        this.notifyAll();
    }

    public static void main(String[] args) {

        ProducerConsumer producerConsumer = new ProducerConsumer();
        Thread t1 = new Thread(() -> {
            for(int i=0;i<1000;i++){
                producerConsumer.produce(i);
            }

        });

        Thread t2 = new Thread(() -> {
            for(int i=0;i<1000;i++){
                producerConsumer.consume();
            }
        });

        t1.start();
        t2.start();

    }
}
