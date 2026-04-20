class Solution {
    public int kthSmallest(int[] arr, int k) {
        // Code here
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        int n = arr.length;
        for(int i=0;i<n;i++)
        {
            maxheap.offer(arr[i]);
            if(maxheap.size()>k)
            maxheap.poll();
        }
        return maxheap.peek();
    }
}
