class Solution {
    public void reverse(int[] arr,int i,int j)
    {
        if(i<0 || i>arr.length-1 || j<0 || j>arr.length)
            return;
        int temp;
        while(i<j)
            {
                temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
    }
    
    public int[] rotateElements(int[] nums, int k) {
        ArrayList<Integer> pos_arr = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            {
                if(nums[i]>=0)
                {
                    pos_arr.add(nums[i]);
                }
            }
        if(pos_arr.size()>0){
            k = (k%pos_arr.size())-1;
            int arr[] = new int[pos_arr.size()];
            for(int i=0;i<arr.length;i++)
                {
                    arr[i]=pos_arr.get(i);
                }
            // System.out.println("k:"+k);
            reverse(arr,0,k);
            reverse(arr,k+1,arr.length-1);
            reverse(arr,0,arr.length-1);
            int j=0;
            for(int i=0;i<nums.length;i++)
                {
                    if(nums[i]>=0)
                    {
                        nums[i]=arr[j];
                        j++;
                    }
                }
            // for(int i=0;i<nums.length;i++){
            //     System.out.println("the le"+nums[i]);
            // }
        }
        return nums;
    }
}