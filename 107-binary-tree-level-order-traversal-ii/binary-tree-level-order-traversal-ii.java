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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList <TreeNode> queue = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> level = new ArrayList<>();
        if(root == null)
        return res;

        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty())
        {
            System.out.println(queue.size()+" "+res.size()+" "+level.size());
            TreeNode node = queue.remove(0);
            if(node == null)
            {
                if(!queue.isEmpty())
                {
                    queue.add(null);
                }
                res.add(0,new ArrayList<>(level));
                level.clear();
            }
            else
            {
                level.add(node.val);
                if(node.left != null)
                queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return res;
    }
}