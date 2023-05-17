/*
338. Counting Bits

Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

Example 1:
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

Example 2:
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 

Constraints:

0 <= n <= 105

Approach:
    Same of number of 1 bits for range of numbers from 0 to n

Timecomplexity:O(n) ~O(n*32)
 */
class Solution {
    public int[] countBits(int n) {
        int[] arr=new int[n+1];
        for(int i=0;i<=n;i++){
            int res=0,num=i;
            while(num>0){
                res+=num&1;
                num>>=1;
            }
            arr[i]=res;
        }
        return arr;
    }
}