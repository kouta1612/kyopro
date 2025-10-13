from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        mp = dict()
        for i in range(len(nums)):
            val = target - nums[i]
            if val in mp:
                return [mp[val], i]
            mp[nums[i]] = i
        return []

print(Solution().twoSum([2, 7, 11, 15], 9))
print(Solution().twoSum([3, 2, 4], 6))
print(Solution().twoSum([3, 3], 6))