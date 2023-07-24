package codingPatterns.dfs;

public class BiPartiteGraph {

    private static boolean isBipartite = true;

    public static void main(String[] args) {

        int n = 4;
        Graph graph = new Graph(n);
        graph.add(0,1);
        graph.add(0,3);
        graph.add(1,2);
        graph.add(2,3);
        graph.add(2,0);
//        graph.add(4,5);


        boolean[] visited = new boolean[n];
        boolean[] color = new boolean[n];
        checkBipartite(graph, 0, visited, color);
        System.out.println(isBipartite);
    }

    private static void checkBipartite(Graph graph, int i, boolean[] visited, boolean[] color) {
        visited[i] = true;
        for(int child: graph.adjacencyList.get(i)) {
            if(!visited[child]) {
                color[child] = !color[i];
                checkBipartite(graph, child, visited, color);
            } else {
                if(color[child] == color[i]) {
                    isBipartite = false;
                    return;
                }
            }
        }
    }
}
