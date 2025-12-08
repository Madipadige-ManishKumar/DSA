class Solution {
    public void traverse(TreeNode node, HashMap<TreeNode, TreeNode> ParentNode, TreeNode[] targetNode, int startValue) {
        if (node == null) return;
        if (node.val == startValue) targetNode[0] = node;

        if (node.left != null) {
            ParentNode.put(node.left, node);
            traverse(node.left, ParentNode, targetNode, startValue);
        }
        if (node.right != null) {
            ParentNode.put(node.right, node);
            traverse(node.right, ParentNode, targetNode, startValue);
        }
    }

public void findPath(TreeNode node, StringBuilder res, HashMap<TreeNode, TreeNode> ParentNode,
                     HashSet<TreeNode> visited, int destValue, int[] flag) {
    if (node == null || visited.contains(node)) return;

    if (node.val == destValue) {
        flag[0] = 1;
        return;
    }

    visited.add(node);

    // Move Up
    if (ParentNode.get(node) != null) {
        res.append('U');
        findPath(ParentNode.get(node), res, ParentNode, visited, destValue, flag);
        if (flag[0] == 1) return;
        res.deleteCharAt(res.length() - 1);
    }

    // Move Left
    if (node.left != null) {
        res.append('L');
        findPath(node.left, res, ParentNode, visited, destValue, flag);
        if (flag[0] == 1) return;
        res.deleteCharAt(res.length() - 1);
    }

    // Move Right
    if (node.right != null) {
        res.append('R');
        findPath(node.right, res, ParentNode, visited, destValue, flag);
        if (flag[0] == 1) return;
        res.deleteCharAt(res.length() - 1);
    }

    visited.remove(node);
}

public String getDirections(TreeNode root, int startValue, int destValue) {
    HashMap<TreeNode, TreeNode> ParentNode = new HashMap<>();
    HashSet<TreeNode> visited = new HashSet<>();
    TreeNode[] targetNode = new TreeNode[]{null};
    StringBuilder res = new StringBuilder();

    traverse(root, ParentNode, targetNode, startValue);

    int[] flag = new int[]{0};
    findPath(targetNode[0], res, ParentNode, visited, destValue, flag);

    return res.toString();
}

}
