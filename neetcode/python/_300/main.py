from typing import List
from bisect import bisect_left

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        res = []

        for num in nums:
            if not res or (res and res[-1] < num):
                res.append(num)
            else:
                li = bisect_left(res, num)
                res[li] = num
        return len(res)

print(Solution().lengthOfLIS([10,9,2,5,3,7,101,18]))