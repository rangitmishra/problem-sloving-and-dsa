package java1.multithreading;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CompletablePractice {

    private static Random random = new Random();

    public static void main(String[] args) {

      /*  int price = getPrice("shop1");
        System.out.println(price);
        Future<Integer> price2 = getPriceAsync("shop1");
        int p2 = 0;
        try {
            p2 = price2.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(p2);*/

        List<String> shops = Arrays.asList("shop1", "shop2");

        ExecutorService exc = Executors.newFixedThreadPool(10, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            }
        });

  /*      List<CompletableFuture<Integer>> futures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> getPrice(shop), exc))
                .collect(Collectors.toList());
        List<Integer> ans = futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        System.out.println(ans);*/

     /*   List<CompletableFuture<String>> futures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> getPrice(shop), exc))
                .map(future -> future.thenCompose(price -> CompletableFuture.supplyAsync(() -> decorateOutput(price))))
                .collect(Collectors.toList());
        List<String> ans = futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        System.out.println(ans);*/

       /* List<CompletableFuture<String>> futures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> getPrice(shop), exc)
                        .thenCombine(CompletableFuture.supplyAsync(() -> getCoupon(shop)),(p,d) -> p+d))
                .collect(Collectors.toList());

        List<String> ans = futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        System.out.println(ans);*/

        Map<String, Integer> map = new HashMap<>();
        map.put("name", 2);
        map.put("age", 4);
        map.put("employecode", 5);






    }

    private static int getPrice(String shop) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return random.nextInt(100);
    }


    private static String decorateOutput(int price) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "" + price;
    }

    private static String getCoupon(String shop) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return shop.toUpperCase() + "00";
    }

    private static CompletableFuture<Integer> getPriceAsync(String shop) {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            future.complete(100);
        });
        t.start();
        return future;
    }


}
