/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode left=null,right = null;
        int count =0;
        ListNode temp = list1;
        while(temp!=null)
        {
            count++;
            if(count == a)
            left=temp;
            if(count == b+2)
            right = temp;
            temp = temp.next;
        }
        // System.out.println("The leftis"+left.val+"The right is"+right.val);
        left.next= list2;
        temp = left.next;
        while(temp.next!= null)
        temp=temp.next;
        temp.next = right;

        return list1;
    }
}