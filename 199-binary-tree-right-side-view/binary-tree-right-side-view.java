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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<TreeNode> queue = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        queue.add(null); 
        List<Integer> level = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove(0);
            if (node == null) {
                res.add(level.get(level.size()-1));
                level.clear();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return res;
    }
}