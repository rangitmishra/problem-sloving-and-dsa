package java1.multithreading.customexecutor;

public class CustomEx {

    public static CustomExService newFixedThreadPool(int n){
        return new FixedThreadEx(n);
    }
}
