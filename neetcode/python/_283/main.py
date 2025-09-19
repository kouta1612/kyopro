from typing import List

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        l = 0
        for r in range(len(nums)):
            if nums[r] != 0:
                nums[l], nums[r] = nums[r], nums[l]
                l += 1

print(Solution().moveZeroes([0,1,0,3,12]))
print(Solution().moveZeroes([0]))
print(Solution().moveZeroes([1]))
print(Solution().moveZeroes([0,0,0,0,0]))
print(Solution().moveZeroes([1,0,1,0,1]))
print(Solution().moveZeroes([0,1,0,1,0]))
print(Solution().moveZeroes([0,1,0,1,0]))