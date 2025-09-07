class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        for i in range(len(nums)):
            part2= int(target-nums[i])
            if   part2  in nums  and  (nums.index(part2) != i) :
                return [nums.index(part2),i]