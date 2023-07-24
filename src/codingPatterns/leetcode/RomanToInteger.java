package codingPatterns.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        String str = "IX";

        int sum = map.get(str.charAt(0));
        for(int i=1;i<str.length();i++){
            char current = str.charAt(i);
            char prev = str.charAt(i-1);
            if(getPrecedence(prev) < getPrecedence(current)){
                sum -= map.get(prev);
                sum += (map.get(current) - map.get(prev));
            } else {
                sum += map.get(current);
            }
        }

        System.out.println(sum);
    }

    private static int getPrecedence(char c){

        switch (c){
            case 'V':
                return 0;
            case 'X':
                return 1;
            case 'L':
                return 2;
            case 'C':
                return 3;
            case 'D':
                return 4;
            case 'M':
                return 5;
        }

        return -1;

    }
}
