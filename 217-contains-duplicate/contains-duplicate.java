class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i:nums)
        {
            if(map.containsKey(i))
            {
                int c=map.get(i);
                c++;
                map.put(i,c);
            }
            else
            {
                map.put(i,1);
            }
        }
        for (Map.Entry<Integer, Integer> en :map.entrySet())
        {
            int key=en.getKey();
            int value =en.getValue();
            if(value>1)
            return true;
        }
        return false;
    }
}