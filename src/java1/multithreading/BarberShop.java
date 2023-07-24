package java1.multithreading;

public class BarberShop {

    private int limit;
    private int count;

    public BarberShop(int limit){
        this.limit = limit;
    }


    public synchronized void occupySeat(){
        if(count == limit){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            System.out.println("Entering customer " + (count+1));
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        count++;
        notifyAll();
    }

    public synchronized void cutHair() {
        if (count == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            System.out.println("Cutting hair for customer " + count);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        count--;
        notifyAll();
    }


    public static void main(String[] args) {
        BarberShop barberShop = new BarberShop(1000000);
        Thread customers = new Thread( () -> {
            while (true){
                barberShop.occupySeat();
            }
        });

        Thread barber = new Thread( () -> {
            while (true){
                barberShop.cutHair();
            }
        });

        customers.start();
        barber.start();

    }
}
