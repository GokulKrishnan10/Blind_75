/*
892 · Alien Dictionary
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. 
Derive the order of letters in this language.
Wechat reply 【Two Sigma】 get the latest requent Interview questions. (wechat id : jiuzhang1104)

You may assume all letters are in lowercase.
The dictionary is invalid, if string a is prefix of string b and b is appear before a.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return the smallest in normal lexicographical order.
The letters in one string are of the same rank by default and are sorted in Human dictionary order.

Example
Example 1:
Input：["wrt","wrf","er","ett","rftt"]
Output："wertf"
Explanation：
from "wrt"and"wrf" ,we can get 't'<'f'
from "wrt"and"er" ,we can get 'w'<'e'
from "er"and"ett" ,we can get 'r'<'t'
from "ett"and"rftt" ,we can get 'e'<'r'
So return "wertf"

Example 2:
Input：["z","x"]
Output："zx"
Explanation：
from "z" and "x"，we can get 'z' < 'x'
So return "zx"

Approach:
    Topological Sort
Timecomplexity:O(E+V)
Spacecomplexity:O(E+V)
 */
import java.util.*;
public class Solution {
    public static char[] getAlienLanguage(int n, String[] dict) {
        // Write your code here.
        StringBuilder sb=new StringBuilder();
        HashMap<Character,HashSet<Character>> map=new HashMap();
        for(String str:dict){
            for(char c:str.toCharArray()){
                map.put(c,new HashSet());
            }
        }
        for(int i=0;i<n-1;i++){
            String w1=dict[i],w2=dict[i+1];
            int n1=w1.length(),n2=w2.length();
            int min=Math.min(n1,n2);
            if(n1>n2 && w1.substring(min).equals(w2.substring(min))){
                return new char[]{};
            }
            for(int j=0;j<min;j++){
                if(w1.charAt(j)!=w2.charAt(j)){
                    map.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }
        HashMap<Character,Boolean> set=new HashMap();
        for(char c:map.keySet()){
            if(dfs(map,set,c,sb)){
                return new char[]{};
            }
        }sb.reverse();
        return sb.toString().toCharArray();
    }
    public static boolean dfs(HashMap<Character,HashSet<Character>> map,HashMap<Character,Boolean> visit,char c,
    StringBuilder sb){
        if(visit.containsKey(c))return visit.get(c);
        visit.put(c,true);
        for(char neigh:map.get(c)){
            if(dfs(map,visit,neigh,sb)){
                return true;
            }
        }
        sb.append(c);
        visit.put(c,false);
        return false;
    }
}
