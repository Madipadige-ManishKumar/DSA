class Solution {
     public static int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            max = Math.max(max, width * arr[i]);
        }

        return max;
    }
    static int maxArea(int matrix[][]) {
         if(matrix.length ==0)
        return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int arr[] = new int[n];
        int max=0;
        for(int i=0;i<m;i++)
        {
            for(int j =0;j<n;j++)
            {
                if(matrix[i][j] == '1')
                {
                    arr[j]+=1;
                }
                else
                arr[j]=0;
            }
            max = Math.max(max,largestRectangleArea(arr));
        }
        return max;
        // code here
        
    }
}