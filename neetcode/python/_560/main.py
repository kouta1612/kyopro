from typing import List

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        res, sums, counters = 0, 0, {0: 1}

        for i in range(len(nums)):
            sums += nums[i]
            res += counters.get(sums - k, 0)
            counters[sums] = counters.get(sums, 0) + 1

        return res

print(Solution().subarraySum([1, 1, 1], 2))
print(Solution().subarraySum([1, 2, 3], 3))
print(Solution().subarraySum([1], 0))