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
    public void traverse(TreeNode node,ArrayList<Integer> arr)
    {
        if (node == null)
        return ;
        arr.add(node.val);
        if(node.left != null ) traverse(node.left,arr);
        if(node.right != null) traverse(node.right,arr);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> res = new ArrayList<>();
        traverse(root1,res);
        traverse(root2,res);
        Collections.sort(res);
        return res;
      
    }
}