class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            int index = Math.abs(nums[i])-1;
            System.out.println(index);
            if(nums[index]<0)
            continue; 
            nums[index]=-nums[index];
        }
        ArrayList<Integer>  res = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            System.out.println(nums[i]);
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            res.add(i+1);
        }
        return res;
    }
}