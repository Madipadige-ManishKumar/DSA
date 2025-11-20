class Solution {
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<TreeNode> queue = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> level = new ArrayList<>();

        if (root == null) return result;

        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove(0);

            if (node == null) {
                // End of one level → compute max
                int mymax = level.get(0);
                for (int i = 1; i < level.size(); i++) {
                    mymax = Math.max(mymax, level.get(i));
                }
                result.add(mymax);
                level.clear();

                // If queue is empty → done
                if (queue.isEmpty()) break;

                // Add delimiter for next level
                queue.add(null);
                continue;
            }

            // Normal node → add to current level
            level.add(node.val);

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return result;
    }
}
