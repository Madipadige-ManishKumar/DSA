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
    public List<Integer> preorderTraversal(TreeNode root) {
            ArrayList <TreeNode> stack = new ArrayList<>();
            ArrayList <Integer> res = new ArrayList<>();
            if(root == null)
            return  res;
            stack.add(root);
            while(stack.size()>0)
            {
                TreeNode temp = stack.remove(stack.size()-1);
                if(temp == null)
                {
                    continue;
                }
                res.add(temp.val);
                if(temp.right != null)
                    stack.add(temp.right);
                if(temp.left != null)
                    stack.add(temp.left);
            }
            return res;
    }
}