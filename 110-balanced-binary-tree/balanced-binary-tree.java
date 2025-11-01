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
    public int  checkheight(TreeNode node,int[] flag)
    {
        if(flag[0] ==1)
        return 0;
        if(node == null)
        return 0;
        int left = this.checkheight(node.left,flag);
        int right = this.checkheight(node.right,flag);
        if (Math.abs(left-right)>1)
        flag[0]=1;
        return Math.max(left,right)+1;
    }
    public boolean isBalanced(TreeNode root) {
        int flag[] = new int[]{0};
        this.checkheight(root,flag);
        if(flag[0]==1)
        return false;
        else
        return true;
    }
}