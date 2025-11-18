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
     =============Rough================

     inorder = 9 3 15 20 7
     indexes = 0 1 2   4 5 

     postorder = 9 15 7 20 3 

     inStart = postStart = 0 
     inEnd = postEnd = 4

     inRoot = 1
     numRight = 4-1 = 3
     

    */
    public TreeNode buildTree(int [] postorder,int postStart,int postEnd,int[] inorder , int inStart,int inEnd,HashMap <Integer,Integer> inmap)
    {
        if(postStart>postEnd||inStart>inEnd) return null;

        TreeNode root =  new TreeNode(postorder[postEnd]);

        int inRoot = inmap.get(root.val);
        int numRight = inEnd - inRoot;

        root.right = this.buildTree(postorder,postEnd-numRight,postEnd-1,inorder,inRoot+1,inEnd,inmap);
        root.left = this.buildTree(postorder,postStart,postEnd-numRight-1 ,inorder,inStart,inRoot-1,inmap);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap <Integer,Integer> inmap = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        inmap.put(inorder[i],i);
        TreeNode root = this.buildTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1,inmap);
        return root;
    }
}