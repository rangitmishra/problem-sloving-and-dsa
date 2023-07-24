package codingPatterns.greedy;

/*
Given an integer N which is the number of villagers who need to cross a river but there is only one boat on which
a maximum of 2 person can travel. Each person i has to pay some specific price Pi to travel alone in the boat.
If two person i, j travel in the boat then they have to pay max(Pi, Pj).
The task is to find the minimum amount all the villagers have to pay to cross the river.

Input: Price[] = {30, 40, 60, 70}
Output: 220
P1 and P2 go together (which costs 40)
and P1 comes back (total cost 70 now).
Now P3 and P4 go (total cost 140) and
P2 comes back (total cost 180) and
finally P1 and P2 go together (total cost 220).


Input: Price[] = {892, 124}
Output: 892

 */
public class MinimumCostToCrossRiver {
}
