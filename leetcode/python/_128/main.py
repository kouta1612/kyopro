from typing import List
from collections import defaultdict


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        counters = defaultdict(int)
        for num in nums: counters[num] += 1
        
        target = set()
        for num in nums:
            if num - 1 not in counters: target.add(num)
        
        res = 0
        for v in target:
            count = 0
            while v in counters:
                count += 1
                v += 1
            res = max(res, count)

        return res

print(Solution().longestConsecutive([100, 4, 200, 1, 3, 2]))
print(Solution().longestConsecutive([0, 3, 7, 2, 5, 8, 4, 6, 0, 1]))