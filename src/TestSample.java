import java.util.HashMap;
import java.util.Map;

public class TestSample {
    private int count = 0;
    /*
    welcome - 0
    to- 1
    freecharge - 2
     */
    private Map<Integer, String> map = new HashMap<>();

    public TestSample(){
        map.put(0, "welcome");
        map.put(1, "to");
        map.put(2, "freecharge");
    }


    public void printMessage(Integer identifier){
        while(count <= 25*3) {
            synchronized (this) {
                while (count % 3 != identifier) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(map.get(identifier) + "(" + Thread.currentThread().getName() + ")" + " ");
                if (count % 3 == 2) {
                    System.out.println();
                }
                count++;
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {

        TestSample testSample = new TestSample();
        Thread t1 = new Thread(() -> testSample.printMessage(0));
        Thread t2 = new Thread(() -> testSample.printMessage(1));
        Thread t3 = new Thread(() -> testSample.printMessage(2));
        t1.start();
        t2.start();
        t3.start();
    }

    /*
     wait - release lock immediately

     notify - release lock but not

     */
}
