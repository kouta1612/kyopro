from typing import List

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        res, s = 0, set(nums)
        for n in s:
            if n - 1 not in s:
                count, cur = 0, n
                while cur in s:
                    cur += 1
                    count += 1
                res = max(res, count)
        return res

print(Solution().longestConsecutive([100, 4, 200, 1, 3, 2]))
print(Solution().longestConsecutive([0, 3, 7, 2, 5, 8, 4, 6, 0, 1]))