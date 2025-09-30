from typing import List

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        perms = [[]]
        for num in nums:
            newPerms = []
            for p in perms:
                for i in range(len(p) + 1):
                    copyPerm = p[:]
                    copyPerm.insert(i, num)
                    newPerms.append(copyPerm)
            perms = newPerms
        return perms

print(Solution().permute([1,2,3]))