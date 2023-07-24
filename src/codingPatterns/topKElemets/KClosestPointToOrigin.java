package codingPatterns.topKElemets;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Problem Statement
Given an array of points in the a 2D plane, find ‘K’ closest points to the origin.
Example 1:
Input: points = [[1,2],[1,3]], K = 1
Output: [[1,2]]
Explanation: The Euclidean distance between (1, 2) and the origin is sqrt(5).
The Euclidean distance between (1, 3) and the origin is sqrt(10).
Since sqrt(5) < sqrt(10), therefore (1, 2) is closer to the origin.
Example 2:
Input: point = [[1, 3], [3, 4], [2, -1]], K = 2
Output: [[1, 3], [2, -1]]
 */
public class KClosestPointToOrigin {

    public static class Point{
        public int x;
        public int y;
        public int distance;

        public Point(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

    }
    public static void main(String[] args) {
        int[][] arr = {{1,3}, {3,4}, {2,-1}};
        int k =2;
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.distance - o2.distance;
            }
        });
        for(int i=0;i<arr.length;i++){
            int distance = arr[i][0]*arr[i][0] + arr[i][1]*arr[i][1];
            Point p = new Point(arr[i][0], arr[i][1], distance);
            pq.add(p);
        }

        int cnt = 0;
        while(cnt < k){
            Point p = pq.poll();
            System.out.println(p.x + "," + p.y);
            cnt++;
        }


    }

}
