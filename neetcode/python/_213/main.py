from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        return max(nums[0], self.helper(nums[1:]), self.helper(nums[:len(nums)-1]))

    def helper(self, nums: List[int]) -> int:
        rob1, rob2 = 0, 0
        for num in nums:
            rob1, rob2 = rob2, max(num + rob1, rob2)
        return rob2
print(Solution().rob([1,2,3,1]))