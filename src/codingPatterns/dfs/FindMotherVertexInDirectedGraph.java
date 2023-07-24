package codingPatterns.dfs;

import java.util.Arrays;

public class FindMotherVertexInDirectedGraph {


    public static void main(String[] args) {

        int n = 5;
        Graph graph = new Graph(n);
        graph.addDirected(0,1);
        graph.addDirected(1,4);
        graph.addDirected(2,1);
        graph.addDirected(2,0);
        graph.addDirected(3,2);

        int lastVisitedNode = -1;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]) {
                lastVisitedNode = i;
                traverse(i, visited, graph);
            }
        }

        Arrays.fill(visited, false);
        traverse(lastVisitedNode, visited, graph);
        boolean isMother = true;
        for(boolean var: visited){
            if(!var){
                isMother = false;
                break;
            }
        }
        if(isMother){
            System.out.println("Mother node is: " + lastVisitedNode);
        } else {
            System.out.println("No mother node exists");
        }
    }

    private static void traverse(int node, boolean[] visited, Graph graph) {

        visited[node] = true;

        for(int child : graph.adjacencyList.get(node)){
            if(!visited[child]) {
                traverse(child, visited, graph);
            }
        }
    }
}
