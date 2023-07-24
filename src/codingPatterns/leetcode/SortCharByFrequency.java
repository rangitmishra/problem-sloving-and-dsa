package codingPatterns.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
https://leetcode.com/problems/sort-characters-by-frequency/

Given a string s, sort it in decreasing order based on the frequency of the characters.
The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.
 */
public class SortCharByFrequency {
    public static void main(String[] args) {
        String input = "tree";
        Map<Character, Integer> map = new HashMap<>();
        for(char c: input.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }


        Map<Character, Integer> sortedMap = map.entrySet()
                .stream().sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (old, neu)->neu, LinkedHashMap::new));


        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry<Character, Integer> e: sortedMap.entrySet()){
            for(int i=0;i<e.getValue();i++){
                stringBuilder.append(e.getKey());
            }
        }

        System.out.println(stringBuilder);
    }
}
