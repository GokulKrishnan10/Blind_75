/*
242. Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
typically using all the original letters exactly once.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false
 
Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

Approach:
    HashTable, Counting
Timecomplexity:O(n)
Spacecomplexity:O(1)
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count1=new int[26];
        int[] count2=new int[26];
        for(char c:s.toCharArray()){
            count1[c-'a']++;
        }
        for(char c:t.toCharArray()){
            count2[c-'a']++;
        }
        return Arrays.equals(count1,count2);
    }
}