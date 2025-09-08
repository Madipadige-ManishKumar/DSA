class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        map={}
        for i in nums:
            if i in map:
                map[i]+=1
            else:
                map[i]=1
        for i in map:
            if map[i]==1:
                return i
        