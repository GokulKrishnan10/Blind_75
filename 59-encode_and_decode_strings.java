/*
659 · Encode and Decode Strings

Design an algorithm to encode a list of strings to a string. The encoded string is then sent over 
the network and is decoded back to the original list of strings.
Please implement encode and decode

Example1
Input: ["lint","code","love","you"]
Output: ["lint","code","love","you"]
Explanation:
One possible encode method is: "lint:;code:;love:;you"

Example2
Input: ["we", "say", ":", "yes"]
Output: ["we", "say", ":", "yes"]
Explanation:
One possible encode method is: "we:;say:;:::;yes"

Approach:
    Strings
Timecomplexity:O(n)
Spacecomplexity:O(1)
 */
public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here
        StringBuilder sb=new StringBuilder();
        for(String s:strs){
            sb.append(s.length());
            sb.append('#');
            sb.append(s);
        }
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        List<String> list=new LinkedList();
        int n=str.length();
        int i=0;
        while(i<n){
            int l=i;
            while(str.charAt(l)!='#'){
                l++;
            }
            int a=Integer.parseInt(str.substring(i,l));
            list.add(str.substring(l+1,l+1+a));
            i=l+a+1;
        }
        return list;
    }
}