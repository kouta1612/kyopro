from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums) - 1
        while l <= r:
            mid = (l + r) // 2
            if nums[mid] == target: return mid
            if nums[mid] <= nums[r]:
                if nums[mid] < target <= nums[r]: l = mid + 1
                else: r = mid - 1
            else:
                if nums[l] <= target < nums[mid]: r = mid - 1
                else: l = mid + 1
        return -1

print(Solution().search([4,5,6,7,0,1,2], 0))
print(Solution().search([4,5,6,7,0,1,2], 3))
print(Solution().search([1], 0))
print(Solution().search([1], 1))
print(Solution().search([1], 2))
print(Solution().search([1], 3))
print(Solution().search([1], 4))
print(Solution().search([1], 5))