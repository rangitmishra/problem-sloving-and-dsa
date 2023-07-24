package java1.multithreading;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CompletableFutureExample {
    Random random = new Random();



    public static void main(String[] args) {

        Executor executor = Executors.newFixedThreadPool(10, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            }
        });

        // get price from multiple airline at once
        CompletableFutureExample obj = new CompletableFutureExample();

        List<String> airlines = Arrays.asList("indigo", "air-asia", "air-india");
        List<CompletableFuture<String>> futurePrices = airlines.stream()
                .map(air -> CompletableFuture.supplyAsync(()->obj.getPrice(air), executor))
                .collect(Collectors.toList());
        List<String> ans = futurePrices.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        System.out.println(ans);

        //get seats then get price
        List<CompletableFuture<String>> seatsPrice = airlines.stream()
                .map(air -> CompletableFuture.supplyAsync(()->obj.getSeat(air), executor))
                .map(future -> future.thenCompose(str -> CompletableFuture.supplyAsync(() -> obj.getPriceAfterSeat(str))))
                .collect(Collectors.toList());
        List<String> ans2 = seatsPrice.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        System.out.println(ans2);


        //get seats and get discount in parallel
        List<CompletableFuture<String>> seatsPriceWithDiscount = airlines.stream()
                .map(air -> CompletableFuture.supplyAsync(()->obj.getSeat(air), executor).thenCombine
                         (CompletableFuture.supplyAsync(() -> obj.getPrice(air)),(p1,p2) -> p1+p2))
                .collect(Collectors.toList());
        List<String> ans3 = seatsPriceWithDiscount.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        System.out.println(ans3);


        List<Quote> quotes = Arrays.asList(new Quote(10, "MFT"), new Quote(30, "APL"), new Quote(20, "IBM"));

        List<CompletableFuture<Result>> result = quotes.stream()
                .map(quote -> CompletableFuture.supplyAsync(() -> obj.doSomeops(quote))
                        .thenCombine(CompletableFuture.supplyAsync(() -> obj.doSomeops2(quote)),(p1, p2) -> {
                            return new Result(quote, p1+p2);
                        }))
                .collect(Collectors.toList());
        List<Result> answer = result.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println(answer);

    }


    public int doSomeops(Quote quote){
        return 10;
    }

    public int doSomeops2(Quote quote){
        return 20;
    }

    static class Quote {
        int price;
        String symbol;
        public Quote(int price, String symbol){
            this.price = price;
            this.symbol = symbol;
        }
    }

    static class Result {
        public Quote quote;
        public int totalPrice;

        public Result(Quote quote, int totalPrice){
            this.quote = quote;
            this.totalPrice = totalPrice;
        }

        public String toString(){
            return quote.symbol + " " + quote.price + " " + this.totalPrice;
        }
    }

    private CompletableFuture<String> getPrice12(String airline){
        CompletableFuture<String> ans = new CompletableFuture<>();
        ans.complete("result");
        return ans;
    }
    private String getPrice(String airline){
        return airline+ "::" +random.nextInt(2000);
    }

    private String getPriceAfterSeat(String str){
        return str+ "::" +random.nextInt(2000);
    }

    private String getSeat(String airline){
        return airline+ "::" +random.nextInt(100);
    }
}
