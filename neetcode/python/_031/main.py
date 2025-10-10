from typing import List

class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        for i in range(len(nums) - 1, -1, -1):
            if i == 0: 
                nums.sort()
                return
            if nums[i-1] < nums[i]:
                for j in range(len(nums) - 1, -1, -1):
                    if nums[i-1] < nums[j]:
                        nums[i-1], nums[j] = nums[j], nums[i-1]
                        break
                j, k = i, len(nums) - 1
                while j < k:
                    nums[j], nums[k] = nums[k], nums[j]
                    j, k = j + 1, k - 1
                return

print(Solution().nextPermutation([1,2,3]))
print(Solution().nextPermutation([3,2,1]))
print(Solution().nextPermutation([1,1,5]))