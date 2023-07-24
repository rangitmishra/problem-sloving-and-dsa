package codingPatterns.bfs;

import codingPatterns.dfs.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

/*
       0
       |
       1
      / \
     2   3
   /  \ /
  4    5
 */
public class UndirectedGraphCycle {

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.add(0,1);
        graph.add(1,2);
        graph.add(1,3);
        graph.add(2,5);
        graph.add(3,5);
        graph.add(2,4);

        boolean isCyclic = bfsCycle(graph);
        System.out.println(isCyclic);

        boolean isCycle = dfsCycle(graph);
        System.out.println(isCycle);
    }

    private static boolean dfsCycle(Graph graph) {
        boolean[] visited = new boolean[graph.n];

        for(int i=0;i<graph.n;i++){
            if(!visited[i]) {
                if(dfsUtil(i, graph, visited, -1)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean bfsCycle(Graph graph) {
        boolean[] visited = new boolean[graph.n];

        for(int i=0;i<graph.n;i++){
            if(!visited[i]) {
                if(bfsUtil(i, graph, visited)){
                    return true;
                }
            }
        }

        return false;
    }

    static class Pair{
        public int parent;
        public int child;

        public Pair(int parent, int child){
            this.parent = parent;
            this.child = child;
        }
    }

    private static boolean bfsUtil(int i, Graph graph, boolean[] visited) {
        visited[i] = true;

        Queue<Pair> queue = new ArrayDeque<>();
        Pair pair = new Pair(-1, i);
        queue.add(pair);

        while(!queue.isEmpty()) {
            Pair parentNode = queue.poll();
            int parent = parentNode.child;

            for(int ch: graph.adjacencyList.get(parent)){
                if(!visited[ch]) {
                    visited[ch] = true;
                    Pair pair1 = new Pair(parent, ch);
                    queue.add(pair1);
                } else {
                    if(ch != parentNode.parent){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean dfsUtil(int i, Graph graph, boolean[] visited, int parent) {
        visited[i] = true;
        for(int ch: graph.adjacencyList.get(i)){
            if(!visited[ch]) {
                if(dfsUtil(ch, graph, visited, i)){
                    return true;
                }
                dfsUtil(ch, graph, visited, i);
            } else {
                if(ch != parent){
                    return true;
                }
            }
        }

        return false;
    }
}
