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
    public void traverse(TreeNode node , int k, HashMap<Integer,Integer> map,boolean []found)
    {
        if(node == null)
        return;
        if(!found[0])
        {
            if(map.get(k-node.val)!= null)
            {
                found[0]=true;
                return;
            }
            map.put(node.val,k-node.val);
            traverse(node.left,k,map,found);
            traverse(node.right,k,map,found);
        }


    }
    public boolean findTarget(TreeNode root, int k) {
        boolean found[]={false};
        traverse(root,k,new HashMap<Integer,Integer>(),found);
        return found[0];
    }
}
