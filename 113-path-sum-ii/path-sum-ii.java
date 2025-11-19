class Solution {

    public void traverse(TreeNode node, int cursum, int targetSum, 
                         ArrayList<Integer> path, List<List<Integer>> allPaths)
    {
        if (node == null)
            return;

        cursum += node.val;
        path.add(node.val);

        // Leaf node & sum matched
        if (node.left == null && node.right == null && cursum == targetSum) {
            allPaths.add(new ArrayList<>(path)); // Add COPY of path
        }

        if (node.left != null)
            this.traverse(node.left, cursum, targetSum, path, allPaths);

        if (node.right != null)
            this.traverse(node.right, cursum, targetSum, path, allPaths);

        path.remove(path.size() - 1); // Backtrack
    }


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) 
    {
        List<List<Integer>> allPaths = new ArrayList<>();
        this.traverse(root, 0, targetSum, new ArrayList<Integer>(), allPaths);
        return allPaths;
    }
}
