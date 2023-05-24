/*
3. Longest Substring Without Repeating Characters

Given a string s, find the length of the longest 
substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 
Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

Approach:
    Sliding Window, HashSet
Timecomplexity:O(n)
Spacecomplexity:O(1)
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0,n=s.length(),max=0;
        HashSet<Character> set=new HashSet();
        while(l<n && r<n){
            char c=s.charAt(r);
            while(set.contains(c)){
                set.remove(s.charAt(l));l++;
            }set.add(c);
            max=Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}