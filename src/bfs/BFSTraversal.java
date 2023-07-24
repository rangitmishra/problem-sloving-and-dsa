package bfs;

import java.util.LinkedList;

public class BFSTraversal {

    public static void main(String[] args) {
        int n = 13;
        GNode gNode = new GNode(n);
        gNode.add(0, 1);
        gNode.add(1,2);
        gNode.add(1,3);
        gNode.add(1,4);

        gNode.add(2,5);
        gNode.add(2,6);
        gNode.add(4,7);
        gNode.add(4,8);

        gNode.add(5,9);
        gNode.add(5,10);

        gNode.add(7,11);
        gNode.add(7,12);

        boolean[] visited = new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]){
                bfs(i, visited, gNode);
            }
        }

    }

    private static void bfs(int i, boolean[] visited, GNode gNode) {

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;
        while(!queue.isEmpty()) {
            int item = queue.pollFirst();
            System.out.println(item);
            for(int a: gNode.lst.get(item)){
                if(!visited[a]) {
                    visited[a] = true;
                    queue.addLast(a);
                }
            }
        }
    }


}
