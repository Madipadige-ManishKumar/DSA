/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public void traverse(TreeNode node,HashMap<TreeNode,TreeNode> parentMap)
    {
        
        if (node.left != null){ 
            parentMap.put(node.left,node);
            traverse(node.left,parentMap);
        }
        if (node.right != null) {
            traverse(node.right,parentMap);
            parentMap.put(node.right,node);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode,TreeNode> parentMap = new HashMap<>();
        traverse(root,parentMap);
        // for(TreeNode k:parentMap.keySet())
        // {
        //     System.out.println(k.val+" "+parentMap.get(k).val+" "+parentMap.get(root));
        // }
        ArrayList<TreeNode> storage = new ArrayList<>();
        // storage.add(p);
        TreeNode temp_p = p;
        TreeNode temp_q =q;
        // storage.add(q);
        while(true)
        {
            if(temp_p != null){
                if(storage.contains(temp_p))
                {
                    return temp_p;
                }
                else
                {
                    storage.add(temp_p);
                    temp_p=parentMap.get(temp_p);
                }
            }
            if(temp_q !=null){
                if(storage.contains(temp_q))
                {
                    return temp_q;
                }
                else
                {
                    storage.add(temp_q);
                    temp_q=parentMap.get(temp_q);
                }
            }

        }
        
    }
}