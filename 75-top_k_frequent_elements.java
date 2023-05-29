/*
347. Top K Frequent Elements

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]
 
Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.

Approach:
    HashMap, PriorityQueue
Timecomplexity:O(N.logN)
Spacecomplexity:O(N)
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->(b[1]-a[1]));
        HashMap<Integer,Integer> map=new HashMap();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            pq.add(new int[]{m.getKey(),m.getValue()});
        }
        int[] arr=new int[k];
        for(int i=0;i<k;i++){
            arr[i]=pq.poll()[0];
        }
        return arr;
    }
}