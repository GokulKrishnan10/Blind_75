/*
153. Find Minimum in Rotated Sorted Array
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.
You must write an algorithm that runs in O(log n) time.
Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

Approach:Binary Search
    1.Array[mid]>Array[mid+1] return Array[mid+1]
    2.Array[mid-1]>Array[mid] return Array[mid]
    3.Array[start]>=A[mid] then search end=mid-1
    4.else start=mid+1
return Array[0]

Timecomplexity: O(nlogn)
Spacecomplexity: O(1)
 */
class Solution {
    public int findMin(int[] nums) {
        int l=0,r=nums.length-1,n=nums.length;
        while(l<r){
            int mid=(l+r)/2;
            if((mid+1)<n && nums[mid]>nums[mid+1])return nums[mid+1];
            else if((mid-1)>=0 && nums[mid-1]>nums[mid])return nums[mid];
            if(nums[l]>=nums[mid]){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return nums[0];
    }
}