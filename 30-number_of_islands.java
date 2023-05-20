/*
200. Number of Islands

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

Approach:
    Graph-DFS on Grid

Timecomplexity:O(n)
Spacecomplexity:O(n)
 */
class Solution {
    boolean[][] visited;
    int m,n;
    public int numIslands(char[][] grid) {
        m=grid.length;n=grid[0].length;
        int count=0;
        visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] G,int r,int c){
        if(r<0 || r>=m || c<0 || c>=n || visited[r][c] || G[r][c]=='0')return;
        visited[r][c]=true;
        dfs(G,r+1,c);
        dfs(G,r,c+1);
        dfs(G,r-1,c);
        dfs(G,r,c-1);
    }
}