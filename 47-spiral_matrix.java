/*
54. Spiral Matrix
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 
Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100

Approach:
    left,right,top,bottom pointer
Timecomplexity:O(n*n)
Spacecomplexity:O(1)
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int l=0,r=n-1,t=0,b=m-1;
        List<Integer> list=new LinkedList();
        while(l<=r && t<=b){
            for(int i=l;i<=r;i++){
                list.add(matrix[t][i]);
            }t++;
            for(int i=t;i<=b;i++){
                list.add(matrix[i][r]);
            }r--;
            if(!(l<=r && t<=b))break;
            for(int i=r;i>=l;i--){
                list.add(matrix[b][i]);
            }b--;
            for(int i=b;i>=t;i--){
                list.add(matrix[i][l]);
            }l++;
        }
        return list;
    }
}