/*
Number of Provinces- number of connected components in a undirected graph

Given an undirected graph with V vertices. We say two vertices u and v belong to a single province 
if there is a path from u to v or v to u. Your task is to find the number of provinces.
Note: A province is a group of directly or indirectly connected cities and no other cities outside of the group.

Example 1:
Input:
[
 [1, 0, 1],
 [0, 1, 0],
 [1, 0, 1]
]
Output:
2
Explanation:
The graph clearly has 2 Provinces [1,3] and [2]. As city 1 and city 3 has a path between them they belong to a single province. 
City 2 has no path to city 1 or city 3 hence it belongs to another province.

Example 2:
Input:
[
 [1, 1],
 [1, 1]
]

Output :
1
 */
class Solution {
    public static void dfs(LinkedList<Integer> list[],int node,boolean[] visited){
        if(visited[node])return;
        visited[node]=true;
        for(int n:list[node]){
            dfs(list,n,visited);
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int count=0;
        LinkedList<Integer> list[]=new LinkedList[V];
        for(int i=0;i<V;i++){
            list[i]=new LinkedList();
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj.get(i).get(j)==1){
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(list,i,visited);
                count++;
            }
        }
        return count;
    }
};