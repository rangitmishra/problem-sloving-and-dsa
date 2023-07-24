package bfs;

import java.util.ArrayList;
import java.util.List;

public class GNode {
    List<List<Integer>> lst = new ArrayList<>();
    int n;
    public GNode(int n){
        for(int i=0;i<n;i++){
            lst.add(new ArrayList<>());
        }
    }

    public void add(int src, int dest){
        lst.get(src).add(dest);
        lst.get(dest).add(src);
    }
}
