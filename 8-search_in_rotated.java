/*
33. Search in Rotated Sorted Array

There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) 
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Approach:
    1.pivot=Find_pivot_Index(maximum element's index in rotated sorted array)
    2.pivot==-1 BinarySearch(0,n,Array,target)
    3.Array[pivot]==target return pivot
    3.Array[start]>target BinarySearch(pivot+1,n,Array,target)
    4.Array[start]<target BinarySearch(0,pivot-1,Array,target)
return -1

Timecomplexity: O(n)
Spacecomplexity: O(1)
 */
class Solution {
    public int findPivot(int[] nums,int target,int n){
        int l=0,r=n-1;
        while(l<r){
            int mid=(l+r)/2;
            if((mid+1)<n && nums[mid]>nums[mid+1])return mid;
            else if((mid-1)>=0 && nums[mid-1]>nums[mid])return mid-1;
            else if(nums[l]>=nums[mid])r=mid-1;
            else l=mid+1;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int n=nums.length;
        int pivot=findPivot(nums,target,n);
        if(pivot==-1)return binarySearch(nums,target,0,n-1);
        else if(nums[pivot]==target)return pivot;
        else if(nums[0]>target)return binarySearch(nums,target,pivot+1,n-1);
        else if(nums[0]<=target)return binarySearch(nums,target,0,pivot-1);
        return -1;
    }
    public int binarySearch(int[] nums,int target,int l,int r){
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target)return mid;
            else if(nums[mid]>target)r=mid-1;
            else l=mid+1;
        }
        return -1;
    }
}