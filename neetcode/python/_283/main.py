from typing import List

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        if len(nums) == 1: return

        j = 1
        for i in range(len(nums)):
            if nums[i] != 0: 
                j = i + 1
                continue
            
            while j < len(nums) and nums[j] == 0:
                j += 1
            if j == len(nums):
                break
            nums[i], nums[j] = nums[j], nums[i]

print(Solution().moveZeroes([0,1,0,3,12]))
print(Solution().moveZeroes([0]))
print(Solution().moveZeroes([1]))
print(Solution().moveZeroes([0,0,0,0,0]))
print(Solution().moveZeroes([1,0,1,0,1]))
print(Solution().moveZeroes([0,1,0,1,0]))
print(Solution().moveZeroes([0,1,0,1,0]))