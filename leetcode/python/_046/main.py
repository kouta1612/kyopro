from typing import List

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        perms = [[]]
        for num in nums:
            newperms = []
            for p in perms:
                for i in range(len(p) + 1):
                    pcopy = p.copy()
                    pcopy.insert(i, num)
                    newperms.append(pcopy)
            perms = newperms
        return perms

print(Solution().permute([1,2,3]))