package codingPatterns.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a maze in the form of the binary rectangular matrix, find the shortest path’s length in a maze from a given source to a given destination.

The path can only be constructed out of cells having value 1, and at any given moment,
we can only move one step in one of the four directions. The valid moves are:

Go Top: (x, y) ——> (x – 1, y)
Go Left: (x, y) ——> (x, y – 1)
Go Down: (x, y) ——> (x + 1, y)
Go Right: (x, y) ——> (x, y + 1)
For example, consider the following binary matrix.
If source = (0, 0) and destination = (7, 5), the shortest path from source to destination has length 12.


 [ 1  1  1  1  1  0  0  1  1  1 ]
 [ 0  1  1  1  1  1  0  1  0  1 ]
 [ 0  0  1  0  1  1  1  0  0  1 ]
 [ 1  0  1  1  1  0  1  1  0  1 ]
 [ 0  0  0  1  0  0  0  1  0  1 ]
 [ 1  0  1  1  1  0  0  1  1  0 ]
 [ 0  0  0  0  1  0  0  1  0  1 ]
 [ 0  1  1  1  1  1  1  1  0  0 ]
 [ 1  1  1  1  1  0  0  1  1  1 ]
 [ 0  0  1  0  0  1  1  0  0  1 ]


 */
public class ShortestpathInMaze {

    static class Coordinates {
        public int x;
        public int y;
        public Coordinates(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        System.out.println(shortestpath());


    }

     public static int shortestpath(){
        int[] col = {-1,1,0,0};
        int[] row = {0,0,-1,1};
        Coordinates dest = new Coordinates(7,5);


        int[][] mat = {{1,1,1,1,1,0,0,1,1,1},
                {0,1,1,1,1,1,0,1,0,1},
                {0,0,1,0,1,1,1,0,0,1},
                {1,0,1,1,1,0,1,1,0,1},
                {0,0,0,1,0,0,0,1,0,1},
                {1,0,1,1,1,0,0,1,1,0},
                {0,0,0,0,1,0,0,1,0,1},
                {0,1,1,1,1,1,1,1,0,0},
                {1,1,1,1,1,0,0,1,1,1},
                {0,0,1,0,0,1,1,0,0,1}};

        Queue<Coordinates> queue = new LinkedList<>();
        queue.add(new Coordinates(0,0));
        int count = 0;
        int incr = 0;
        while(!queue.isEmpty()) {
            incr = queue.size();
            while(incr > 0){
                Coordinates c = queue.poll();
                if(c.x == dest.x && c.y == dest.y){
                    return count;
                }
                for(int i=0;i<4;i++){
                    if(isValid(mat, c.x+row[i], c.y+col[i])){
                        queue.add(new Coordinates(c.x+row[i],c.y+col[i]));
                    }
                }
                incr--;

            }
            count++;

        }
        return 0;
    }

    private static boolean isValid(int[][] mat, int row, int col) {
        if(row < 0 || col < 0 || row >= mat.length || col >= mat[0].length || mat[row][col] == 0){
            return false;
        }
        return true;
    }
}
