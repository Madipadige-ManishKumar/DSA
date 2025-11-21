/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/




/*


In this first make the tree bidirectional 

Map 1 <TreeNode,TreeNode>
{
    child : parent 
    
    1: null  // not stroing it 
    2:1
    3:1
    4:2
    5:2
    6:3
    7:3
}




Map 2 <TreeNode , Integer>
{
// 0 is on fire and 1 is not set on fire 
    1:1
    2:1
    3:1
    4:1
    5:1
    6:1
    7:1
}


Queue:ArrayList<TreeNode>

if(root == null)
return 0;
int count=0;
Queue.add(node );  // 2
Map2.put(node,0);
while(!Queue.isEmptu())
{
    TreeNode node = Queue.remove(0);
    if(node.left != null)
    {
        if(Map2.get(node.left))
            Queue.add(node.left);
        Map2.put(node.left,0);  // 4
    }
    if(node.right  != null)
    {
        if(Map2.get(node.right))
            Queue.ad(node.right);
        Map2.put(node.right,0);
    }
    if(Map1.get(node) != null)
    {
        if(Map2.get(Map1.get(node)))
        {
            Queue.add(Map2.get(Map1.get(node)));
        }
        Map2.put(Map1.get(node),0)
    }
    int sum=0;
    for(TreeNode key : Map2.getKeys())
    {
        sum+=Map2.get(key);
    }
    if(sum == 0)
    return count;
    count++;
}

sum of all elements in Map2
if(sum ==0)
return count;



*/

class Solution {
    
    private Node buildParentMap(Node root, int target, Map<Node, Node> parent) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node targetNode = null;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.data == target) {
                targetNode = curr;
            }

            if (curr.left != null) {
                parent.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                parent.put(curr.right, curr);
                q.add(curr.right);
            }
        }
        return targetNode;
    }

    public int minTime(Node root, int target) {
        if (root == null) return 0;

        Map<Node, Node> parent = new HashMap<>();
        Node targetNode = buildParentMap(root, target, parent);

        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        q.add(targetNode);
        visited.add(targetNode);

        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean burned = false; 

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.add(curr.left);
                    burned = true;
                }

            
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.add(curr.right);
                    burned = true;
                }

                
                if (parent.containsKey(curr) && !visited.contains(parent.get(curr))) {
                    visited.add(parent.get(curr));
                    q.add(parent.get(curr));
                    burned = true;
                }
            }
            
            if (burned) time++;   
        }

        return time;
    }
}
