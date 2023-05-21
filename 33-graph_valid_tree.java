/*
178 · Graph Valid Tree
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example
Example 1:
Input: n = 5 edges = [[0, 1], [0, 2], [0, 3], [1, 4]]
Output: true.

Example 2
Input: n = 5 edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]
Output: false.

Approach:
    DFS-and-visit set

Timecomplexity:O(E+V)
Spacecomplexity:O(E+V)
 */
public class Solution {
    public static boolean dfs(LinkedList<Integer> list[],HashSet<Integer> visit,int node,int prev){
        if(visit.contains(node))return false;
        visit.add(node);
        for(int n:list[node]){
            if(n==prev)continue;
            if(!dfs(list,visit,n,node)){
                return false;
            }
        }
        return true;
    }
    public static Boolean checkGraph(int[][] edges, int n, int m) {
        // Write your code here
        LinkedList<Integer> list[]=new LinkedList[n];
        for(int i=0;i<n;i++){
            list[i]=new LinkedList();
        }
        for(int[] arr:edges){
            list[arr[0]].add(arr[1]);
            list[arr[1]].add(arr[0]);
        }
        HashSet<Integer> set=new HashSet();
        return dfs(list,set,0,-1) && set.size()==n;
    }
}