/*
76. Minimum Window Substring

Given two strings s and t of lengths m and n respectively, return the minimum window 
substring of s such that every character in t (including duplicates) is included in the window. 
If there is no such substring, return the empty string "".
The testcases will be generated such that the answer is unique.

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 
Constraints:
m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.

Approach:
    Sliding Window, HashTable
Timecomplexity:O(n)
Spacecomplexity:O(1)
 */
class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        int n1=s.length(),n2=t.length();
        int[] count1=new int[58];
        int[] count2=new int[58];
        for(char c:t.toCharArray()){
            count1[c-'A']++;
        }
        int l=0,r=0,start=-1,end=-1,min=Integer.MAX_VALUE;
        while(l<=n1 && r<=n1){
            if(check(count1,count2)){
                int m=r-l+1;
                if(min>m){
                    min=m;
                    start=l;end=r;
                }
                char c=s.charAt(l);
                if(count2[c-'A']!=0){
                    count2[c-'A']--;
                }l++;
            }else{
                if(r<n1){
                    char c=s.charAt(r);
                    count2[c-'A']++;
                }
                r++;
            }
        }
        if(start==-1 && end==-1)return "";
        return s.substring(start,end);
    }
    public boolean check(int[] count1,int[] count2){
        for(int i=0;i<58;i++){
            if(count1[i]==0 || count2[i]>=count1[i]){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}