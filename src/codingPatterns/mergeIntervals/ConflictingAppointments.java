package codingPatterns.mergeIntervals;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Statement
Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.

Example 1:

Appointments: [[1,4], [2,5], [7,9]]
Output: false
Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.

Example 2:

Appointments: [[6,7], [2,4], [8,12]]
Output: true
Explanation: None of the appointments overlap, therefore a person can attend all of them.

Example 3:

Appointments: [[4,5], [2,3], [3,6]]
Output: false
Explanation: Since [4,5] and [3,6] overlap, a person cannot attend both of these appointments.
 */
public class ConflictingAppointments {
    static class Point {
        public int start;
        public int end;

        public Point(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        List<Point> meetings = Arrays.asList(new Point(4,5), new Point(2,3), new Point(3,6));
        System.out.println(extracted(meetings));
    }

    private static boolean extracted(List<Point> meetings) {
        meetings.sort((p1, p2) -> p1.start - p2.start);

        for(int i = 0; i< meetings.size()-1; i++){
            if(meetings.get(i).end > meetings.get(i+1).start){
                return false;
            }
        }

        return true;
    }
}
