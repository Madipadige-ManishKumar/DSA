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
    public void traverse(TreeNode node ,ArrayList<Integer> ans)
    {
        if(node == null)
        return ;
        traverse(node.left,ans);
        ans.add(node.val);
        traverse(node.right,ans);
        
    }
    public boolean isValidBST(TreeNode root) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
        return true;
        traverse(root,ans);        
        for(int i=1;i<ans.size();i++)
        {
            if(ans.get(i-1)>=ans.get(i))
            return false;
        }
        return true;
    }
}