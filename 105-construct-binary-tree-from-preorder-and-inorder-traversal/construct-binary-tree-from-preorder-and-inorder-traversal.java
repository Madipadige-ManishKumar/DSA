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
    public TreeNode buildTree(int []preorder,int preStart,int preEnd,int [] inorder,int inStart,int inEnd,HashMap<Integer,Integer> inmap)
    {
        if(preStart>preEnd || inStart >inEnd)return null;
        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = inmap.get(root.val);
        int numleft = inRoot - inStart;

        root.left = buildTree(preorder,preStart+1,preStart+numleft,inorder,inStart,inRoot-1,inmap);
        root.right = buildTree(preorder,preStart+numleft+1,preEnd,inorder,inRoot+1,inEnd,inmap);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> inmap = new HashMap<>();
        for(int i =0;i<inorder.length;i++)
        {
            inmap.put(inorder[i],i);
        }
        TreeNode root = this.buildTree(preorder,0,preorder.length-1,inorder, 0,inorder.length-1,inmap);
        return root;
    }
}


/*

inorder  =  9 3 15 20 7

index =    0 1 2  3  4

preorder = 3 9 20 15 7

inmap = {3:0,9:1,20:2,15:3,7:4}

inRoot =  1

numLeft = 1-0 =1

rootleft= 
        prorder = [3,9]  // PreStart = 0 PreEnd = PreStart+numleft = 0+1=1
        inorder  = [9]

rootRight
        prorder  = [20,15,7]
        inorder = 



*/