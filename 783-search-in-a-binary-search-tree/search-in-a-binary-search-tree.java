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
    public TreeNode traverse(TreeNode node,int val)
    {
        if(node == null ) 
            return null;
        if(node.val==val) 
        {
        
            return node;
        }
        else if(node.val<val)   
        {
            return traverse(node.right,val);
        }
        else 
        {
            return traverse(node.left,val);
        }
    }
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode searchNode = null;
        return traverse(root,val);
    }
}