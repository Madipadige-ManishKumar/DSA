class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int n = nums1.length;
        int m = nums2.length;
        int next_greater[] = new int[m];
        int res[] = new int[n];
       for(int i=m-1;i>=0;i--)
       {
            while(!(st.empty()) && st.peek()<=nums2[i])
            {
                st.pop();
            }

            if(st.empty())
            next_greater[i]=-1;
            else
            next_greater[i]=st.peek();
            st.push(nums2[i]);
       }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(nums1[i]==nums2[j])
                {
                    res[i]=next_greater[j];
                }
            }
        }
       
        return res;
    }
}