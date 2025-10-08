from typing import List

class Solution:
    def findMin(self, nums: List[int]) -> int:
        l, r = 0, len(nums) - 1
        while l < r:
            mid = (l + r) // 2
            if nums[mid] > nums[r]: l = mid + 1
            else: r = mid
        return nums[r]

print(Solution().findMin([3,4,5,1,2]))
print(Solution().findMin([4,5,6,7,0,1,2]))
print(Solution().findMin([1]))
print(Solution().findMin([2,1]))
print(Solution().findMin([1,2]))
print(Solution().findMin([2,1]))