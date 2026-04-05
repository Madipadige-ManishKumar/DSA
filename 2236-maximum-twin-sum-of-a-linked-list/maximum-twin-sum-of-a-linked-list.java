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
    public int pairSum(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp != null)
        {
            arr.add(temp.val);
            temp = temp.next;
        }
        int max_sum = -1;
        int n  = arr.size();
        for(int i=0;i<=(n/2)-1;i++)
        {
            int twin = (n-1-i);
            twin = arr.get(twin)+arr.get(i);

            max_sum = Math.max(twin,max_sum);
        }
        return max_sum;
    }
}