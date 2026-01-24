/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp = node;
        ListNode parent = node;
        while(temp.next != null)
        {
            temp.val = temp.next.val;
            parent=temp;
            temp=temp.next;    
        }
        parent.next = null;
        
    }
}