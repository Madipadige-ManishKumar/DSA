class Solution {
    public ListNode removeNodes(ListNode head) {

        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }

        int n = arr.size();
        int[] res = new int[n]; 

        
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int val = arr.get(i);

            while (!st.isEmpty() && st.peek() <= val) {
                st.pop();
            }

            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(val);
        }

        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int i = 0; i < n; i++) {
            if (res[i] == -1) {
                curr.next = new ListNode(arr.get(i));
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}