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
    public void findmax(ArrayList<Integer> arr,TreeNode node)
    {
         for(int i=0;i<arr.size();i++)
            {
                if(arr.get(i)>node.val)  // 3 > 1
                {
                    arr.add(i,node.val);
                    return ;
                }
            }
            arr.add(node.val);
    }
    public void traverse(TreeNode node,ArrayList<Integer> arr)
    {  // 1
        if(node == null)
        return;
        if(arr.size()==0)
        {
            arr.add(node.val);  // 3
            
        }
        else{
           this.findmax(arr,node);
        }
        this.traverse(node.left,arr);
        this.traverse(node.right,arr);
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        this.traverse(root,arr);
        return arr.get(k-1);
    }
}