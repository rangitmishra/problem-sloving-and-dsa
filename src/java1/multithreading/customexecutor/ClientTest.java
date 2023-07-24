package java1.multithreading.customexecutor;

//https://www.youtube.com/watch?v=3Uo7MfXY4to

public class ClientTest {

    public static void main(String[] args) {
        CustomExService customExService = CustomEx.newFixedThreadPool(5);
        for(int i=0;i<4;i++){
            customExService.execute(() -> {
                System.out.println("Hello");
            });
        }
    }
}
