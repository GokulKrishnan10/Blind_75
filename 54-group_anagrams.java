/*
49. Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
typically using all the original letters exactly once.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]
 
Constraints:
1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

Approach:
    HashTable, Sorting
Timecomplexity:O(n)
Spacecomplexity:O(n)
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap();
        for(String s:strs){
            char[] arr=s.toCharArray();
            Arrays.sort(arr);
            String str=new String(arr);
            if(map.containsKey(str)){
                map.get(str).add(s);
            }else{
                map.put(str,new LinkedList());
                map.get(str).add(s);
            }
        }
        List<List<String>> list=new LinkedList();
        list.addAll(new LinkedList(map.values()));
        return list;
    }
}