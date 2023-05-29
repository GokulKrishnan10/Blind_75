/*
211. Design Add and Search Words Data Structure

Design a data structure that supports adding new words and finding if a string matches any previously added string.
Implement the WordDictionary class:
WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 
Example:
Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 
Constraints:
1 <= word.length <= 25
word in addWord consists of lowercase English letters.
word in search consist of '.' or lowercase English letters.
There will be at most 2 dots in word for search queries.
At most 104 calls will be made to addWord and search.

Approach:
    Trie
Timecomplexity:O()
Spacecomplexity:O()
 */
class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    public TrieNode(){
        children=new TrieNode[26];
        isEnd=false;
    }
}
class WordDictionary {
    TrieNode root=new TrieNode();
    public WordDictionary() {
        
    }
    
    public void addWord(String word) {
        TrieNode node=root;
        for(char c:word.toCharArray()){
            if(node.children[c-'a']==null)node.children[c-'a']=new TrieNode();
            node=node.children[c-'a'];
        }
        node.isEnd=true;
    }
    
    public boolean search(String word){
        return search(word,root);
    }

    public boolean search(String word,TrieNode node) {
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(c=='.'){
                for(TrieNode child:node.children){
                    if(child!=null && search(word.substring(i+1),child)){
                        return true;
                    }
                }
                return false;
            }
            else if(node.children[c-'a']==null)return false;
            node=node.children[c-'a'];
        }
        return node.isEnd;
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */