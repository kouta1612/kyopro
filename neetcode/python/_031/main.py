from typing import List

class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = -1
        for j in range(len(nums) - 2, -1, -1):
            if nums[j] < nums[j + 1]:
                i = j
                break
        if i == -1:
            nums.sort()
            return

        for j in range(len(nums) - 1, -1, -1):
            if nums[i] < nums[j]:
                nums[i], nums[j] = nums[j], nums[i]
                break
        l, r = i + 1, len(nums) - 1
        while l < r:
            nums[l], nums[r] = nums[r], nums[l]
            l += 1
            r -= 1

print(Solution().nextPermutation([1,2,3]))
print(Solution().nextPermutation([3,2,1]))
print(Solution().nextPermutation([1,1,5]))