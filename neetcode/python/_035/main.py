from typing import List

class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        l,r = 0, len(nums)
        while l + 1 != r:
            mid = (l + r) // 2
            if target == nums[mid]:
                return mid
            elif target < nums[mid]:
                r = mid
            else:
                l = mid
        if nums[l] < target:
            return r
        else:
            return l

print(Solution().searchInsert([1,3,5,6], 5))
print(Solution().searchInsert([1,3,5,6], 2))
print(Solution().searchInsert([1,3,5,6], 7))
print(Solution().searchInsert([1,3,5,6], 0))
print(Solution().searchInsert([1,3,5,6], 4))
print(Solution().searchInsert([1,3,5,6], 6))
print(Solution().searchInsert([1,3,5,6], 1))
print(Solution().searchInsert([1,3,5,6], 3))
print(Solution().searchInsert([1,3,5,6], 5))
print(Solution().searchInsert([1,3,5,6], 6))