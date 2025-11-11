/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

class Solution {
    public void markParent(TreeNode root, HashMap<TreeNode, TreeNode> parent_track) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left != null) {
                parent_track.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                parent_track.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParent(root, parent_track);

        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();

        queue.offer(target);
        visited.put(target, true);
        int curLevel = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (curLevel == k) break;
            curLevel++;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null && visited.get(current.left) == null) {
                    visited.put(current.left, true);
                    queue.offer(current.left);
                }
                if (current.right != null && visited.get(current.right) == null) {
                    visited.put(current.right, true);
                    queue.offer(current.right);
                }
                if (parent_track.get(current) != null && visited.get(parent_track.get(current)) == null) {
                    visited.put(parent_track.get(current), true);
                    queue.offer(parent_track.get(current));
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (TreeNode node : queue) {
            result.add(node.val);
        }
        return result;
    }
}
