from typing import List

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        if len(nums) == 0:
            return [[]]

        res = []
        perms = self.permute(nums[1:])
        for p in perms:
            for i in range(len(p) + 1):
                pcopy  = p[:]
                pcopy.insert(i, nums[0])
                res.append(pcopy)
        return res

print(Solution().permute([1,2,3]))