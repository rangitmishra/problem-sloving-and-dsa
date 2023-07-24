package codingPatterns.dp;


import java.util.HashMap;
import java.util.Map;

/*
In how many ways boys and girls can be arranged so that no girls sit together
 */
public class BoysGirlsSeating {

    private static Map<String, Ans> map = new HashMap<>();

    static class Ans {
        int ways;
        boolean isValid;

        public Ans(int ways, boolean isValid){
            this.ways = ways;
            this.isValid = isValid;
        }

    }

    public static void main(String[] args) {
        int b = 7;
        int g = 5;
        boolean prevSsGirl = false;
        Ans a = getSeatingArrangements(prevSsGirl, b, g);
        System.out.println(a.ways);


    }

    private static Ans getSeatingArrangements(boolean prevSsGirl, int b, int g) {

        //System.out.println(String.format("G=%s, B=%s",g,b) );
        String key = prevSsGirl + ":" + b + ":" + g;
        if(map.get(key) != null){
            return map.get(key);
        }

        if(b==0&&g==0){
            return new Ans(1, true);
        }

        if(g < 0 || b < 0){
            return new Ans(0, false);
        }

        if(g > b+1){
            return new Ans(0, false);
        }

        Ans girlTaken = null;
        if(!prevSsGirl) {
            girlTaken = getSeatingArrangements(true,b, g-1);
        }

        Ans boyTaken = getSeatingArrangements(false, b-1, g);

        if(girlTaken != null && girlTaken.isValid && boyTaken.isValid){
            Ans ans = new Ans(g*girlTaken.ways+ b*boyTaken.ways, true);
            map.put(key, ans);
            return ans;
        } else if(girlTaken != null && girlTaken.isValid){
            Ans ans = new Ans(g*girlTaken.ways, true);
            map.put(key, ans);
            return ans;
        } else if(boyTaken.isValid){
            Ans ans = new Ans(b*boyTaken.ways, true);
            map.put(key, ans);
            return ans;
        }

        Ans ans = new Ans(0, false);
        map.put(key, ans);
        return ans;

    }
}
