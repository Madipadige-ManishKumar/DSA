class Solution {

    public void traverse(TreeNode node, StringBuffer s, int[] totalSum)
    {
        if (node == null)
            return;
        s.append(node.val);
        if (node.left == null && node.right == null) {
            totalSum[0] += Integer.parseInt(s.toString());
        }
        if (node.left != null) {
            this.traverse(node.left, s, totalSum);
        }
        if (node.right != null) {
            this.traverse(node.right, s, totalSum);
        }        
        s.deleteCharAt(s.length() - 1);
    }

    public int sumNumbers(TreeNode root) {
        StringBuffer s = new StringBuffer();
        int[] totalSum = new int[]{0};
        this.traverse(root, s, totalSum);
        return totalSum[0];
    }
}
