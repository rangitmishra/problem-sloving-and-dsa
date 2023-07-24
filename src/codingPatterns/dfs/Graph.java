package codingPatterns.dfs;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public int n;
    public List<List<Integer>> adjacencyList;

    public Graph(int n){
        this.n = n;
        adjacencyList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void add(int src, int dest){
        this.adjacencyList.get(src).add(dest);
        this.adjacencyList.get(dest).add(src);
    }

    public void addDirected(int src, int dest){
        this.adjacencyList.get(src).add(dest);
    }


}
