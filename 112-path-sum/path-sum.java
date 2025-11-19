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

    /*
            ===================== Rough Space =========================
                    5   0    22   f 
                    4   5    22   f
                    11  9    22   f
                    7   18   22   f
                    null 25  22   f
                    11 

    */

public void traverse(TreeNode node ,int cursum,int targetSum,Boolean[] flag)
{
    if(flag[0] || node == null)
        return ;

    cursum += node.val;

    // Check only when node is a leaf
    if(node.left == null && node.right == null && cursum == targetSum) {
        flag[0] = true;
        return;
    }

    if(node.left != null)
        this.traverse(node.left, cursum, targetSum, flag);

    if(node.right != null)
        this.traverse(node.right, cursum, targetSum, flag);
}

public boolean hasPathSum(TreeNode root, int targetSum) {
    Boolean flag[] = new Boolean[]{false};
    this.traverse(root, 0, targetSum, flag);
    return flag[0];
}
 
}