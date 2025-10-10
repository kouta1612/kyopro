from typing import List

class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        i = -1
        for j in range(len(nums) - 1, 0, -1):
            if nums[j-1] < nums[j]:
                i = j
                break
        if i == -1:
            nums.sort()
            return
        
        # nums[i:]の中でnums[i-1]よりも大きい要素のインデックスと値を交換
        for j in range(len(nums) - 1, -1, -1):
            if nums[i-1] < nums[j]:
                nums[i-1], nums[j] = nums[j], nums[i-1]
                break

        # nums[i:]は降順ソートされている
        j = len(nums) - 1
        while i < j:
            nums[i], nums[j] = nums[j], nums[i]
            i, j = i + 1, j - 1

print(Solution().nextPermutation([1,2,3]))
print(Solution().nextPermutation([3,2,1]))
print(Solution().nextPermutation([1,1,5]))