class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()  # Sort the list

        result = set()  # Use a set to store unique triplets

        for i in range(len(nums) - 2):
            # Use two pointers approach for the rest of the array
            left = i + 1
            right = len(nums) - 1
            
            while left < right:
                total = nums[i] + nums[left] + nums[right]
                
                if total == 0:
                    result.add((nums[i], nums[left], nums[right]))  # Add the triplet to the set
                    left += 1  # Move the left pointer to the right
                    right -= 1  # Move the right pointer to the left
                elif total < 0:
                    left += 1  # Move the left pointer to the right
                else:
                    right -= 1  # Move the right pointer to the left

        # Convert the set of tuples to a list of lists
        result = [list(triplet) for triplet in result]
        return result

# Test the solution
