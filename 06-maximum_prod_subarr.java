/*
152. Maximum Product Subarray
Given an integer array nums, find a subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

Approach:
    DP , Keeping the maximum and minimum so far obtained and calculate the answer

Timecomplexity: O(n)
Spacecomplexity: O(1)

*/
class Solution {
    public int maxProduct(int[] nums) {
        int curMax=nums[0],curMin=nums[0],max=nums[0],n=nums.length;
        for(int i=1;i<n;i++){
            int cMax=curMax,cMin=curMin;
            curMax=Math.max(Math.max(cMin*nums[i],cMax*nums[i]),nums[i]);
            curMin=Math.min(Math.min(cMin*nums[i],cMax*nums[i]),nums[i]);
            max=Math.max(curMax,max);
        }
        return max;
    }
}