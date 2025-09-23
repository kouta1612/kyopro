from typing import List

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        prefixSum, counter, freq = 0, 0, {0: 1}
        for i in range(len(nums)):
            prefixSum += nums[i]
            counter += freq.get(prefixSum - k, 0)
            freq[prefixSum] = 1 + freq.get(prefixSum, 0)
        return counter

print(Solution().subarraySum([1, 1, 1], 2))
print(Solution().subarraySum([1, 2, 3], 3))
print(Solution().subarraySum([1], 0))