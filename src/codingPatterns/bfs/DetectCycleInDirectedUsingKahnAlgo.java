package codingPatterns.bfs;

import java.util.ArrayList;
import java.util.List;

/*

1
 */
public class DetectCycleInDirectedUsingKahnAlgo {

    class NodeT {
        int value;
        List<List<NodeT>> adjacencyList;
        public NodeT(int value){
            this.value = value;
            this.adjacencyList = new ArrayList<>();
        }
    }
}
