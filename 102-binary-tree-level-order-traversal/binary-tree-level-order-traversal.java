import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<TreeNode> queue = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        queue.add(null); 
        List<Integer> level = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove(0);
            if (node == null) {
                res.add(new ArrayList<>(level));
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
