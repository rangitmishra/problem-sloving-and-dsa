package codingPatterns.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Statement
Given a list of non-overlapping intervals sorted by their start time, insert a given interval at the correct position and
merge all necessary intervals to produce a list that has only mutually exclusive intervals.
Example 1:
Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
Output: [[1,3], [4,7], [8,12]]
Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
Example 2:
Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
Output: [[1,3], [4,12]]
Explanation: After insertion, since [4,10] overlaps with [5,7] & [8,12], we merged them into [4,12].
Example 3:
Input: Intervals=[[2,3],[5,7]], New Interval=[1,4]
Output: [[1,4], [5,7]]
Explanation: After insertion, since [1,4] overlaps with [2,3], we merged them into one [1,4].
 */
public class InsertInterval {

    static class Point {
        public int start;
        public int end;

        public Point(int start, int end){
            this.start = start;
            this.end = end;
        }
        public Point(){}

        public String toString(){
            return start + ", " + end ;
        }

    }

    public static void main(String[] args) {

        List<Point> points = Arrays.asList(new Point(2,3), new Point(5,7));
        Point add = new Point(1,4);
        List<Point> ans = new ArrayList<>();
        boolean ent = false;
        boolean once = false;
        //Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
        for(int i=0;i<points.size();i++){
            if(points.get(i).start > add.start && !once){
                //go back
                Point np = new Point();
                np.start = add.start;
                np.end = add.end;
                if(i > 0 && points.get(i-1).end >= add.start){
                    np.start = points.get(i-1).start;
                    if(ans.size() > 0){
                        ans.remove(ans.size()-1);
                    }
                }
                //go front
                while(i< points.size() && add.end > points.get(i).start){
                    ent = true;
                    np.end = Math.max(add.end, points.get(i).end);
                    i++;
                }

                if(ent){
                    i--;
                }
                ans.add(np);
                once = true;
            } else {
                ans.add(points.get(i));

            }

        }

        for(Point p: ans){
            System.out.println(p.toString());
        }

    }
}
