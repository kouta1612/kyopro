from typing import List

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        res, counters = 0, {0: 1}
        sums = [0] * (len(nums) + 1)

        for i in range(len(nums)):
            sums[i + 1] = sums[i] + nums[i]
            key = sums[i + 1] - k
            res += counters.get(key, 0)
            counters[sums[i + 1]] = counters.get(sums[i + 1], 0) + 1

        return res

print(Solution().subarraySum([1, 1, 1], 2))
print(Solution().subarraySum([1, 2, 3], 3))
print(Solution().subarraySum([1], 0))