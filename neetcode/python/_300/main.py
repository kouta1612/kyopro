from typing import List
from bisect import bisect_left

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        res = []
        for num in nums:
            if res and res[-1] >= num:
                l, r = 0, len(res) - 1
                while l < r:
                    mid = (l + r) // 2
                    if res[mid] >= num: r = mid
                    else: l = mid + 1
                res[l] = num
            else: res.append(num)
        return len(res)

print(Solution().lengthOfLIS([10,9,2,5,3,7,101,18]))