package java1.multithreading;

public class TokenBucketUsingThread {


    private int maxToken;
    private int tokenAddedPerSec;
    private long lastUpdatedTime = System.currentTimeMillis();
    private int availableTokens = 0;

    public TokenBucketUsingThread(int maxToken, int tokenAddedPerSec){
        this.maxToken = maxToken;
        this.tokenAddedPerSec = tokenAddedPerSec;
        Thread dt = new Thread(() -> daemonThread());
        dt.setDaemon(true);
        dt.start();
    }

    private void daemonThread(){
        while(true){
            synchronized (this){
                availableTokens += tokenAddedPerSec;
                if(availableTokens > maxToken){
                    availableTokens = maxToken;
                }
                this.notifyAll();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void getToken()  {
        synchronized (this){
            while(availableTokens == 0){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            availableTokens--;
            System.out.println("Grant token to " + Thread.currentThread().getName() +" at " + (System.currentTimeMillis()/1000L));
        }

    }
}
