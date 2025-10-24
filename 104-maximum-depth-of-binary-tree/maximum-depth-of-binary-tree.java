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
    public int maxDepth(TreeNode root) {
        if (root == null)
        return 0;
        ArrayList <TreeNode> queue = new ArrayList<>();
        int maxdep=0;
        queue.add(root);
        queue.add(null);
        while(queue.size()>0)
        {
            TreeNode temp = queue.remove(0);
            if(temp == null )
            {
                maxdep++;
                if (queue.size()>0)
                {
                    queue.add(null);
                }
            }
            if (temp != null){
            if(temp.left != null)
            {
                queue.add(temp.left);
            }
            if (temp.right != null)
            queue.add(temp.right);
            }
        }
        return maxdep;
    }
}