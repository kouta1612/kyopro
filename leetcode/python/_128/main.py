from typing import List
from collections import defaultdict


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        numSet = set()
        for num in nums: numSet.add(num)
        
        target = set()
        for num in nums:
            if num - 1 not in numSet: target.add(num)
        
        res = 0
        for v in target:
            count = 0
            while v in numSet:
                count += 1
                v += 1
            res = max(res, count)

        return res

print(Solution().longestConsecutive([100, 4, 200, 1, 3, 2]))
print(Solution().longestConsecutive([0, 3, 7, 2, 5, 8, 4, 6, 0, 1]))