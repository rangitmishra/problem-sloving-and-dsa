package codingPatterns;

import java.util.ArrayList;
import java.util.List;

/*
print all the subsequence
 */
public class PrintString {

    public static void main(String[] args) {


        String str = "ABC";

        List<String> ans = printStr(str);
        //System.out.println(ans);
    }

    private static List<String> printStr(String str) {

        if(str.length() == 1){
            List<String> ans = new ArrayList<>();
            ans.add(String.format("%s", str));
            System.out.println(str);
            return ans;
        }
        List<String> ans = printStr(str.substring(1));
        List<String> ans2 = new ArrayList<>(ans);

        for(String a: ans){
            ans2.add(String.format("%s%s", str.substring(0,1), a));
            System.out.println(String.format("%s%s", str.substring(0,1), a));
            ans2.add(String.format("%s%s", str.substring(0,1) + " ", a));
            System.out.println(String.format("%s%s", str.substring(0,1) + " ", a));
        }
        return ans2;
    }
}
