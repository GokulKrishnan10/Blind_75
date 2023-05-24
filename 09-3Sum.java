/*
15. 3Sum

Given an integer array nums, return all the 
triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Approach: 
    Sorting, HashSet and nested for loops(2 nested)

Timecomplexity: O(n^2) (as well sorting O(nlogn))
Spacecomplexity: O(1)
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set=new HashSet();
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            int l=i+1,r=n-1;
            while(l<r){
                int s=nums[i]+nums[l]+nums[r];
                if(s==0){
                    List<Integer> list=Arrays.asList(nums[i],nums[l],nums[r]);
                    set.add(list);
                    l++;r--;
                }
                if(s<0)l++;
                if(s>0)r--;
            }
        }
        List<List<Integer>> res=new LinkedList();
        res.addAll(set);
        return res;
    }
}