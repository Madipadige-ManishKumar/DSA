class Solution {
    int upperBound(int[] arr, int target) {
        // code here
        int index=arr.length;
        int low =0;
        int high = arr.length-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            // System.out.println(mid+"ths is mid and the element is "+arr[mid]);
            if(arr[mid] > target)
            {
                index=mid;
                high = mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return index;
    }
}
