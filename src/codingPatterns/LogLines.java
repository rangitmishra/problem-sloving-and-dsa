package codingPatterns;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LogLines {

    static class Logs{
        String data;
        int time;

        public Logs(String data, int time){
            this.data = data;
            this.time = time;
        }

        public String toString(){
            return data + " " + time;
        }
    }

    public static void main(String[] args) {
        List<Logs> logs = Arrays.asList(new Logs("l1", 10), new Logs("l2", 13),
                new Logs("l3", 1), new Logs("l4", 3),new Logs("l5", 5),
                new Logs("l6", 7), new Logs("l7", 2), new Logs("l8", 9));

        logs.sort((log1, log2) -> log1.time - log2.time);
        System.out.println(logs);

        List<Logs> ans = query(0,3, logs);
        System.out.println(ans);


    }

    private static List<Logs> query(int l, int r, List<Logs> logs) {

        int lIdx = getPosGreaterOrEqual(logs, l);
        System.out.println(lIdx);

        int rIdx = getPosSmallerOrEqual(logs, r);
        System.out.println(rIdx);
        return logs.subList(lIdx, rIdx + 1);
    }

    private static int getPosSmallerOrEqual(List<Logs> logs, int num) {
        int l = 0;
        int r = logs.size()-1;

        while (l < r){
            int mid = (l+r)/2;
            if(logs.get(mid).time > num){
                r = mid-1;
            } else {
                l = mid;
                if(r-l==1){
                    if(logs.get(r).time > num){
                        return l;
                    }
                    return r;
                }
            }

        }
        return l;
    }

    private static int getPosGreaterOrEqual(List<Logs> logs, int num) {
        int l = 0;
        int r = logs.size()-1;

        while (l < r){
            int mid = (l+r)/2;
            if(logs.get(mid).time < num){
                l = mid+1;
            } else {
                r = mid;
            }

        }
        return l;
    }
}
