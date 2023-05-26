/*
125. Valid Palindrome

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing 
all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 
Constraints:
1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.

Approach:
    two pointers
Timecomplexity:O(n)
Spacecomplexity:O(1)
 */
class Solution {
    public boolean isValid(char c){
        return ((c>=97 && c<=122) || (c>=48 && c<=57));
    }
    public boolean isPalindrome(String s) {
        int l=0,n=s.length(),r=n-1;
        s=s.toLowerCase();
        char[] arr=s.toCharArray();
        while(l<=r){
            if(isValid(arr[l]) && isValid(arr[r])){
                if(arr[l]==arr[r]){
                    l++;r--;
                }else return false;
            }else if(isValid(arr[l])){
                r--;
            }else if(isValid(arr[r])){
                l++;
            }else{
                l++;r--;
            }
        }
        return true;
    }
}