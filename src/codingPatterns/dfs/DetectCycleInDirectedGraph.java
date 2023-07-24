package codingPatterns.dfs;

import java.util.HashSet;
import java.util.Set;

public class DetectCycleInDirectedGraph {

    static boolean isCycle = false;

    public static void main(String[] args) {

        Graph graph = new Graph(5);
        graph.addDirected(0,1);
        graph.addDirected(1,2);
        graph.addDirected(1,3);
        graph.addDirected(3,4);
        graph.addDirected(4,1);
        Set<Integer> path = new HashSet<>();
        boolean[] visited = new boolean[5];
        checkIsCycle(graph, path, visited, 0);
        System.out.println(isCycle);


    }

    private static void checkIsCycle(Graph graph, Set<Integer> path, boolean[] visited, int i) {
        visited[i] = true;
        path.add(i);
        for(int c: graph.adjacencyList.get(i)){
            if(!visited[c]) {
                checkIsCycle(graph, path, visited, c);
            } else {
                if(path.contains(c)){
                    isCycle = true;
                    return;
                }
            }
        }
        path.remove(i);
    }
}
