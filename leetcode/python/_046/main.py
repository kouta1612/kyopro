from typing import List

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        if not nums: return [[]]
        res = []
        perms = self.permute(nums[1:])
        for perm in perms:
            for i in range(len(perm) + 1):
                permcopy = perm.copy()
                permcopy.insert(i, nums[0])
                res.append(permcopy)
        return res

print(Solution().permute([1,2,3]))