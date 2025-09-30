from typing import List

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        res = []
        for bit in range(1<<n):
            sub = []
            for i in range(n):
                if bit & 1<<i:
                    sub.append(nums[i])
            res.append(sub)
        return res

print(Solution().subsets([1,2,3]))