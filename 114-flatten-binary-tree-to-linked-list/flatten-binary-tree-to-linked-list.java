class Solution {
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> stack = new ArrayList<>();
        ArrayList<TreeNode> res = new ArrayList<>();

        if (root == null)
            return;

        stack.add(root);
        while (stack.size() > 0) {
            TreeNode temp = stack.remove(stack.size() - 1);
            res.add(temp);

            if (temp.right != null)
                stack.add(temp.right);
            if (temp.left != null)
                stack.add(temp.left);
        }

        TreeNode temp = res.get(0);
        for (int i = 1; i < res.size(); i++) {
            temp.left = null;
            temp.right = res.get(i);
            temp = temp.right;
        }
    }
}
