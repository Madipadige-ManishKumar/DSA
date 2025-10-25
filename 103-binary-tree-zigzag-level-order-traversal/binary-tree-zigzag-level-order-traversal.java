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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList <TreeNode> queue = new ArrayList<>();
        ArrayList <List<Integer>>  res =  new ArrayList<>();  // []
        if(root == null)
        {
            return res;
        }
        int count =0;
        queue.add(root);  // 3 
        queue.add(null);   // 3 null 
        TreeNode temp;
        ArrayList <Integer> arr  = new ArrayList<>();  // []
        Boolean lefttoright=true;
        while(queue.size()>0)
        {
            temp =queue.remove(0); // temp = null 
            if(temp==null) 
            {
                if(lefttoright){
                lefttoright=false;
                res.add(new ArrayList<>(arr)); // res =[[3],[9,20],[15,7]]
                }
                else
                {
                    Collections.reverse(arr);
                    res.add(new ArrayList<>(arr));
                    lefttoright=true;
                }
                if(queue.size()>0)
                {
                    queue.add(null); 
                    arr.clear(); // arr  = []
                }
            }
            else{
            arr.add(temp.val);  // arr = [15,7]            
            if (temp.left != null) queue.add(temp.left);  // 
            if(temp.right != null) queue.add(temp.right); // 
            }
        }

        return res;
       
    }
}