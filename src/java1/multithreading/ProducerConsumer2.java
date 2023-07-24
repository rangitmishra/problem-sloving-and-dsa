package java1.multithreading;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer2 {

    int size = 10;
    Queue<Integer> queue = new ArrayDeque<>(size);

    private ReentrantLock lock = new ReentrantLock(true);

    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public void produce(int n){
        lock.lock();
        try {
            while (queue.size() == size) {
                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Produced " + n);
            queue.add(n);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }


    public synchronized void consume(){
        lock.lock();
        try{
            while (queue.size() == 0) {
                try {
                    notEmpty.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Consumed " + queue.poll());
            notFull.signalAll();
        } finally {
            lock.unlock();
        }
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
