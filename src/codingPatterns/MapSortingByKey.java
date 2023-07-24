package codingPatterns;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MapSortingByKey {

    public static void main(String[] args) {

        Map<String, Integer> unsortedMap = Map.of("a", 1, "c", 3, "b", 2, "e", 5, "d", 4);
        TreeMap<String, Integer> treeMap = new TreeMap<>(unsortedMap);
        System.out.println(treeMap);

        TreeMap<String, Integer> treeMapReverse = new TreeMap<>(Comparator.reverseOrder());
        treeMapReverse.putAll(unsortedMap);
        System.out.println(treeMapReverse);

        LinkedHashMap<String, Integer> sortedMap =
                unsortedMap.entrySet().stream().sorted((e1,e2) -> e2.getValue() - e1.getValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldVal, newVal) -> oldVal, LinkedHashMap::new));
        System.out.println(sortedMap);

        unsortedMap = Map.of("a", 1, "c", 3, "b", 2, "e", 5, "d", 4);

        sortedMap =
                unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldVal, newVal) -> oldVal, LinkedHashMap::new));
        System.out.println(sortedMap);
    }
}
