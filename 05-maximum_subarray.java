/*
53. Maximum Subarray

Given an integer array nums, find the 
subarray
 with the largest sum, and return its sum.
 
Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

APPROACH: Kadane's Algorithm

Time Complexity:O(n)
Space Complexity:O(1)
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int maxS=nums[0],max=nums[0],n=nums.length;
        for(int i=1;i<n;i++){
            maxS=Math.max(maxS+nums[i],nums[i]);
            max=Math.max(maxS,max);
        }
        return max;
    }
}