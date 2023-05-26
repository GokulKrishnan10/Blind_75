/*
5. Longest Palindromic Substring
Medium
25.2K
1.5K
Companies
Given a string s, return the longest palindromic substring  in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters.

Approach:
    Two pointers
Timecomplexity:O(N^2)
Spacecomplexity:O(1)
 */
class Solution {
    public String longestPalindrome(String s) {
        int n=s.length(),max=0,start=0,end=0;
        for(int i=0;i<n;i++){
            int l=i,r=i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                l--;r++;
            }
            if(max<(r-l+1)){
                start=l+1;end=r-1;
                max=(r-l+1);
            }
            l=i;r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                l--;r++;
            }
            if(max<(r-l+1)){
                start=l+1;end=r-1;
                max=(r-l+1);
            }
        }
        return s.substring(start,end+1);
    }
}