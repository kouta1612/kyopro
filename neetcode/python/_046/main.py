from typing import List

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        perms = [[]]
        for num in nums:
            newPerms = []
            for perm in perms:
                for i in range(len(perm) + 1):
                    copyPerm = perm[:]
                    copyPerm.insert(i, num)
                    newPerms.append(copyPerm)
            perms = newPerms
        return perms

print(Solution().permute([1,2,3]))