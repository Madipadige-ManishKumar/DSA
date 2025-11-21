/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static void traverse(ArrayList<ArrayList<Integer>> res , ArrayList<Integer> path,Node node)
    {
        if(node == null)
        {
            return;
        }
        path.add(node.data);
        if(node.left == null && node.right == null)
        {
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        Solution.traverse(res,path,node.left);
        Solution.traverse(res,path,node.right);
        
        path.remove(path.size()-1);
        
    }
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
         ArrayList<ArrayList<Integer>>  res = new ArrayList<>();
         ArrayList<Integer> path = new ArrayList<>();
         Solution.traverse(res,path,root);
         return res;
        
    }
}