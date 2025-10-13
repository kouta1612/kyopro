from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        pre, cur = 0, 0
        for num in nums:
            pre, cur = cur, max(cur, pre + num)
        return cur

print(Solution().rob([1,2,3,1]))