class Solution {
    public int maxArea(int[] arr) {
        int i,j;
        i=0;
        j=arr.length-1;
        int my_max=Math.min(arr[i],arr[j])*Math.abs(i-j);
        while(j>=0 && i<arr.length)
        {
            if(arr[i]<arr[j])
            {
                i++;
            }
            else
            {
                j--;
            }
            if(j>=0&&i<arr.length){
            if (Math.min(arr[i],arr[j])*Math.abs(i-j)>my_max){
            my_max=Math.min(arr[i],arr[j])*Math.abs(i-j);
            }
            }
        }
        return my_max;
    }
}