from typing import List

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        res, sum, counter = 0, 0, {0: 1}
        for num in nums:
            sum += num
            res += counter.get(sum - k, 0)
            counter[sum] = counter.get(sum, 0) + 1
        return res

print(Solution().subarraySum([1, 1, 1], 2))
print(Solution().subarraySum([1, 2, 3], 3))
print(Solution().subarraySum([1], 0))