package java1.multithreading;

public class TokenBucket {

    private int maxToken;
    private int possibleToken;
    private long lastUpdatedTime = System.currentTimeMillis();

    private int tokenAddedPerSecond;

    public TokenBucket(int maxToken, int tokenAddedPerSecond){
        this.maxToken = maxToken;
        this.tokenAddedPerSecond = tokenAddedPerSecond;
    }

    public synchronized void getToken(){

        possibleToken += ((System.currentTimeMillis() - lastUpdatedTime)/1000)*tokenAddedPerSecond;

        if(possibleToken > maxToken){
            possibleToken = maxToken;
        }
        if(possibleToken == 0){
            System.out.println("--------- Sleeping --------");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("-------Not Sleeping--------   " + possibleToken);
            possibleToken--;
        }

        lastUpdatedTime = System.currentTimeMillis();
        System.out.println("Granting " + Thread.currentThread().getName() + " token at " + (System.currentTimeMillis()/1000L));

    }
}
