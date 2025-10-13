from typing import List

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        def helper(i: int, subs: List[int]):
            if i == len(nums):
                res.append(subs)
                return
            
            helper(i + 1, subs)
            helper(i + 1, subs + [nums[i]])
        
        helper(0, [])
        return res

print(Solution().subsets([1,2,3]))