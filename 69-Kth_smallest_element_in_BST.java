/*
230. Kth Smallest Element in a BST

Given the root of a binary search tree, and an integer k, 
return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

Constraints:
The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104

Approach:
	DFS, Inorder traversal
Timecomplexity:O(n)
Spacecomplexity:O(n)
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int c=1,ans=-1;
    public void inOrder(TreeNode root,int k){
        if(root!=null){
            if(ans!=-1)return;
            inOrder(root.left,k);
            if(c==k && ans==-1){
                ans=root.val;
            }c++;
            inOrder(root.right,k);
            if(ans!=-1)return;
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return ans;
    }
}