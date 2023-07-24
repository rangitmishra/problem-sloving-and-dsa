package java1.multithreading.customexecutor;

import java.util.concurrent.BlockingQueue;

public class FixedThreadEx implements CustomExService{
    public static int totalThread;

    public static int currentThread = 0;

    public static BlockingQueue<Runnable> taskBlockingQueue;

    private ExecutionEngine executionEngine;

    public FixedThreadEx(int totalThread){
        this.totalThread = totalThread;
    }

    @Override
    public void execute(Runnable runnable) {
        taskBlockingQueue.add(runnable);
        executionEngine.execute(runnable);

    }
}
