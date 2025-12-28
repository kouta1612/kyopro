from typing import List

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = [[]]
        for n in nums:
            newres = []
            for perm in res:
                for i in range(len(perm) + 1):
                    newperm = perm[:i] + [n] + perm[i:]
                    newres.append(newperm)
                res = newres
        return res

print(Solution().permute([1,2,3]))