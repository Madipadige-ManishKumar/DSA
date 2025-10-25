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
    public Boolean traverse(TreeNode tree1, TreeNode tree2)
    {
        if(tree1 == null && tree2 == null)
        {
            return true;
        }
        else if(tree1 == null || tree2 == null)
        return false;
        if(tree1.val == tree2.val)
        return traverse(tree1.left,tree2.right) && traverse(tree1.right,tree2.left);
        return false;
    }
    public boolean isSymmetric(TreeNode root) {
        return this.traverse(root,root);
    }
}