/*217. Contains Duplicate
Companies
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false

APPROACH: HashSet
Time Complexity: O(n)
Space Complexity: O(n)
*/ 
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet();
        for(int i:nums){
            if(set.contains(i))return true;
            set.add(i);
        }
        return false;
    }
}