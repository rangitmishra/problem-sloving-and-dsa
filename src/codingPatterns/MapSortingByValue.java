package codingPatterns;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSortingByValue {

    public static void main(String[] args) {

        Map<String, Integer> unsortedMap = Map.of("a", 3, "c", 1, "b", 2, "e", 5, "d", 4);

        HashMap<String, Integer> sortedMap = unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o,n)->o, LinkedHashMap::new));
        System.out.println(sortedMap);

        unsortedMap = Map.of("a", 3, "c", 1, "b", 2, "e", 5, "d", 4);

        sortedMap = unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o,n)->o, LinkedHashMap::new));
        System.out.println(sortedMap);
    }
}
