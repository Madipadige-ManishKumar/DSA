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
    public int findBottomLeftValue(TreeNode root) {
        ArrayList<TreeNode> queue = new ArrayList<>();
        ArrayList<Integer> level  = new ArrayList<>();

        if(root == null)
        return 0;
        int res = root.val;
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty())
        {
            TreeNode node = queue.remove(0);
            if(node == null)
            {
                if(level.size()>0){
                queue.add(null);                
                res = level.remove(0);
                level.clear();
                }
            }
            else
            {
                level.add(node.val);
                if(node.left != null)
                queue.add(node.left);
                if(node.right != null)
                queue.add(node.right);
            }
        }
        return  res;
    }
}