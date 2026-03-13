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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
        return 0;
        ArrayList<Integer> level = new ArrayList<>();
        q.offer(root);
        q.add(null);
        int sum =0;
        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            if(node == null)
            {
                if(!q.isEmpty())
                {
                    q.offer(null);
                    sum=0;
                }
                else
                {
                   return sum; 
                }
                continue;
            }
            sum+=node.val;
            if(node.left != null) q.offer(node.left);
            if(node.right != null) q.offer(node.right);
        }
        return sum;
    }
}