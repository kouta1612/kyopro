from typing import List

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        s = set()

        def dfs(perm: List[int]):
            if len(perm) == len(nums):
                res.append(perm[:])
                return

            for j in range(len(nums)):
                if j in s: continue
                perm.append(nums[j])
                s.add(j)
                dfs(perm)
                perm.pop()
                s.remove(j)

        dfs([])
        return res

print(Solution().permute([1,2,3]))