package java1.multithreading.customexecutor;

public class ExecutionEngine implements Runnable{

    public void execute(Runnable runnable){
        if(FixedThreadEx.currentThread < FixedThreadEx.totalThread){
            Thread t = new Thread(new ExecutionEngine());
            t.start();
        }

    }
    @Override
    public void run() {
        while(true){
            if(!FixedThreadEx.taskBlockingQueue.isEmpty()){
                FixedThreadEx.taskBlockingQueue.poll().run();
            }
        }

    }
}
