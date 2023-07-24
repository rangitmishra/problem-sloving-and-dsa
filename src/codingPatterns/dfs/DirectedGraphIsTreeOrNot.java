package codingPatterns.dfs;

/*
1. Find the root of the tree, which is the vertex with no incoming edges. If no node exists, then return false.
If more than one node exists, then the graph is not connected, and we should return false as well.
2. Perform a DFS to check that each node has exactly one parent. If not, return false.
3. Make sure that all nodes are visited. If the DFS check didn’t visit all nodes, then return false.
4. Otherwise, the graph is a tree
 */
public class DirectedGraphIsTreeOrNot {
}
