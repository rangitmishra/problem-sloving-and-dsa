package codingPatterns.dp;

import java.util.HashMap;
import java.util.Map;

public class JugWaterProblem {

    private static int N = 56;
    private static int M = 8;
    private static Map<String, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        int x = 46;

        int count = 0;
        printTrx(0, 0, x, count);
    }

    private static void printTrx(int n, int m, int x, int count) {
        if(n==x || m ==x){
            System.out.println("n=" + n +", m=" + m + ", count=" + count);
            return;
        }

        String key = String.format("%s_%s",n,m);
        if(map.containsKey(key)){
            return;
        }else {
            map.put(key, true);
        }

        if(n==0){
            printTrx(N,m,x,count+1);
            printTrx(n,M,x,count+1);
            if(m != 0){
                int temp = Math.min(N,n+m);
                int temp1 = Math.max(0, m-temp);
                printTrx(temp,temp1,x,count+1);
            }
        } else {
            printTrx(0,m,x,count+1);
            int temp = Math.min(M, m+n);
            int temp1 = Math.max(0, n-(M-m));
            printTrx(temp1,temp,x,count+1);
            if(m != 0){
                int temp2 = Math.min(N,n+m);
                int temp3 = Math.max(0, m-(N-n));
                printTrx(temp2,temp3,x,count+1);
                printTrx(n,0,x,count+1);
            }
        }

    }
}
