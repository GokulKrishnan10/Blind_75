/*
212. Word Search II

Given an m x n board of characters and a list of strings words, return all words on the board.
Each word must be constructed from letters of sequentially adjacent cells, 
where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example 1:

Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]

Example 2:
Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.

Approach:
    Trie, DFS
Timecomplexity:O(4^(M*N))
Spacecomplexity:O(N)
 */
class TrieNode{
    boolean isEnd;
    TrieNode[] children;
    public TrieNode(){
        children=new TrieNode[26];
        isEnd=false;
    }
}
class Solution {
    Set<String> list;
    TrieNode root;
    int m,n;
    boolean[][] visited;
    public void addWord(String word,TrieNode root){
        TrieNode node=root;
        for(char c:word.toCharArray()){
            if(node.children[c-'a']==null)node.children[c-'a']=new TrieNode();
            node=node.children[c-'a'];
        }
        node.isEnd=true;
    }
    public List<String> findWords(char[][] board, String[] words) {
        root=new TrieNode();
        list=new HashSet();
        for(String w:words){
            addWord(w,root);
        }        
        m=board.length;
        n=board[0].length;
        visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(board,i,j,root,"");
            }
        }
        return list.stream().collect(Collectors.toList());
    }
    public void dfs(char[][] A,int r,int c,TrieNode node,String s){
        if(r<0 || c<0 || r>=m || c>=n || visited[r][c] || node.children[A[r][c]-'a']==null)return;
        visited[r][c]=true;
        node=node.children[A[r][c]-'a'];
        s+=A[r][c];
        if(node.isEnd){
            list.add(s);
        }
        dfs(A,r+1,c,node,s);
        dfs(A,r-1,c,node,s);
        dfs(A,r,c+1,node,s);
        dfs(A,r,c-1,node,s);
        visited[r][c]=false;
    }
}